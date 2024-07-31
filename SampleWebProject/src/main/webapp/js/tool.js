//Event on button click
let btn = document.getElementById('change-btn');
btn.addEventListener('click', function() {
let msgObj = document.getElementById('msg');
msgObj.innerHTML = 'Button clicked';
});