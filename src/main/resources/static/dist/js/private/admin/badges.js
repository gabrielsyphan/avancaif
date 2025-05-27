let editingBadgeId = null;
let editingId = null;

function generateImage() {
    const seed = Math.random().toString(36).substring(7);
    document.getElementById('badgePreview').src =
        `https://api.dicebear.com/8.x/bottts/svg?seed=${seed}`;
}

function saveBadge() {
    const title = document.getElementById('title').value.trim();
    const description = document.getElementById('description').value.trim();
    const select = document.getElementById('technologies');
    const technologies = Array.from(select.selectedOptions).map(opt => opt.value);
    const imageUrl = document.getElementById('badgePreview').src;

    const badge = {
        title,
        description,
        technologies,
        imageUrl
    };

    const url = editingId ? `/api/v1/badges/update/${editingId}` : '/api/v1/badges/create';
    const method = editingId ? 'PUT' : 'POST';

    fetch(url, {
        method: method,
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(badge)
    })
    .then(res => {
        if (res.ok) {
            swal("Sucesso!", `Badge ${editingId ? 'atualizada' : 'criada'} com sucesso!`, "success").then(() => {
                editingId = null;
                clearForm();
                loadBadges();
            });
        } else {
            swal("Erro!", "Não foi possível salvar a badge. Tente novamente.", "error");
        }
    });
}


function editBadge(id) {
    const badge = badges.find(b => b.id === id);
    if (!badge) return;

    editingId = id;

    document.getElementById('title').value = badge.title;
    document.getElementById('description').value = badge.description;

    const select = document.getElementById('technologies');
    Array.from(select.options).forEach(option => {
        option.selected = badge.technologies.includes(option.value);
    });

    document.getElementById('badgePreview').src = badge.imageUrl;
}

function deleteBadge(id) {
    swal({
        title: "Tem certeza?",
        text: "Essa ação não poderá ser desfeita!",
        icon: "warning",
        buttons: ["Cancelar", "Sim, excluir!"],
        dangerMode: true,
    }).then((willDelete) => {
        if (willDelete) {
            fetch(`/api/v1/badges/${id}/delete`, { method: 'DELETE' })
                .then(res => {
                    if (res.ok) {
                        swal("Excluído!", "Badge excluída com sucesso.", "success").then(() => {
                            loadBadges();
                        });
                    } else {
                        swal("Erro!", "Não foi possível excluir a badge.", "error");
                    }
                });
        }
    });
}

function resetForm() {
    editingBadgeId = null;
    document.querySelector('input[placeholder="Ex.: Explorador de Desafios"]').value = '';
    document.querySelector('textarea').value = '';
    const select = document.querySelector('select');
    Array.from(select.options).forEach(option => option.selected = false);
    document.getElementById('badgePreview').src = "https://api.dicebear.com/8.x/bottts/svg?seed=placeholder";
}

function loadBadges() {
    fetch('/api/v1/badges/all')
    .then(response => response.json())
    .then(data => {
        badges = data; // 👉 Armazena localmente
        const tbody = document.getElementById('badgesTableBody');
        tbody.innerHTML = '';

        badges.forEach(badge => {
            const row = document.createElement('tr');

            row.innerHTML = `
                <td class="px-4 py-2 flex items-center gap-2">
                    <img src="${badge.imageUrl}" alt="Badge" class="w-8 h-8 rounded-full border border-gray-300"/>
                    <span>${badge.title}</span>
                </td>
                <td class="px-4 py-2">${badge.description}</td>
                <td class="px-4 py-2">${badge.technologies.join(', ')}</td>
                <td class="px-4 py-2 flex items-center gap-3">
                    <button onclick="editBadge(${badge.id})" class="text-yellow-500 hover:text-yellow-600 transition" title="Editar">
                        <i data-lucide="edit" class="w-4 h-4"></i>
                    </button>
                    <button onclick="deleteBadge(${badge.id})" class="text-red-500 hover:text-red-600 transition" title="Excluir">
                        <i data-lucide="trash" class="w-4 h-4"></i>
                    </button>
                </td>
            `;

            tbody.appendChild(row);
        });
        lucide.createIcons();
    })
    .catch(err => console.error('Erro ao carregar badges:', err));
}

function clearForm() {
    document.getElementById('title').value = '';
    document.getElementById('description').value = '';
    const select = document.getElementById('technologies');
    Array.from(select.options).forEach(opt => opt.selected = false);
    document.getElementById('badgePreview').src = 'https://api.dicebear.com/8.x/bottts/svg?seed=placeholder';
    editingId = null;
}

function deleteBadge(id) {
    swal({
        title: "Tem certeza?",
        text: "Essa ação não pode ser desfeita!",
        icon: "warning",
        buttons: ["Cancelar", "Excluir"],
        dangerMode: true,
    }).then((willDelete) => {
        if (willDelete) {
            fetch(`/api/v1/badges/delete/${id}`, {
                method: 'DELETE'
            })
            .then(res => {
                if (res.ok) {
                    swal("Badge excluída com sucesso!", { icon: "success" })
                    .then(() => loadBadges());
                } else {
                    swal("Erro ao excluir a badge.", { icon: "error" });
                }
            });
        }
    });
}

function logout() {
    window.location.href = "/logout";
}

window.onload = loadBadges;