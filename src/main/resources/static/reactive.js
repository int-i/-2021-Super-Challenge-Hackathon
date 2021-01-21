const toggleBtn = document.querySelector('.navbar__toggleBtn');
const right = document.querySelector('.nav_right');

toggleBtn.addEventListener('click', ()=> {
    right.classList.toggle('active');  
});