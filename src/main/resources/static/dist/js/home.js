const token = localStorage.getItem('token');

const loginBtn = document.getElementById('login-btn');
const registerBtn = document.getElementById('register-btn');

const loginNavBtn = document.getElementById('login-nav-btn');
const registerNavBtn = document.getElementById('register-nav-btn');

if (token) {
    const homeBtn = document.getElementById('home-btn');
    const homeNavBtn = document.getElementById('home-nav-btn');
    const logoutNavBtn = document.getElementById('logout-nav-btn');

    loginBtn.style.display = 'none';
    registerBtn.style.display = 'none';
    loginNavBtn.style.display = 'none';
    registerNavBtn.style.display = 'none';

    homeBtn.style.display = 'flex';
    homeNavBtn.style.display = 'inline-block';
    logoutNavBtn.style.display = 'inline-block';

    homeBtn.addEventListener('click', function() {
        window.location.href = '/dash';
    });
} else {
    loginBtn.style.display = 'flex';
    signupBtn.style.display = 'flex';
}

function logout() {
    localStorage.removeItem('token');
    localStorage.removeItem('email');
    window.location.href = '/';
}