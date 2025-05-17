const form = document.getElementById('registerForm');
const loader = document.getElementById('loaderOverlay');

form.addEventListener('submit', async function (e) {
  e.preventDefault();

  loader.style.display = 'flex';

  const data = {
    name: form.name.value,
    email: form.email.value,
    password: form.password.value,
    role: form.role.value
  };

  try {
    const response = await fetch('/api/v1/register', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(data)
    });

    loader.style.display = 'none';

    if (response.ok) {
      swal("Sucesso!", "Cadastro realizado com sucesso!", "success").then(() => {
        window.location.href = "/login";
      });
    } else {
      const err = await response.json();
      swal("Erro!", err.message || "Não foi possível realizar o cadastro.", "error");
    }
  } catch (error) {
    loader.style.display = 'none';
    swal("Erro!", "Erro de conexão com o servidor.", "error");
  }
});
