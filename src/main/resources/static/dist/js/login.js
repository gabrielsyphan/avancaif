const form = document.getElementById('loginForm');
const loader = document.getElementById('loaderOverlay');

const token = localStorage.getItem('token');
if (token) {
    localStorage.removeItem('token');
    localStorage.removeItem('email');
}

form.addEventListener('submit', async function (e) {
  e.preventDefault();

  loader.style.display = 'flex';

  const data = {
    email: form.email.value,
    password: form.password.value
  };

  try {
    const response = await fetch('/api/v1/login', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(data)
    });

    loader.style.display = 'none';

    if (response.ok) {
        response.json().then(data => {
          localStorage.setItem('token', data.token);
          localStorage.setItem('email', data.email);
          window.location.href = "/dash";
        });
    } else {
      const err = await response.json();
      swal("Erro!", err.message || "Não foi possível fazer login.", "error");
    }
  } catch (error) {
    loader.style.display = 'none';
    swal("Erro!", "Erro de conexão com o servidor.", "error");
  }
});
