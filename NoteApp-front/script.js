// La recuperation des elements 
const form = document.querySelector("#form");
const matricule = document.querySelector('#matricule');
const password = document.querySelector('#password');

// Evenements
form.addEventListener('submit', e => {
    e.preventDefault();
    form_verify();
})

// Fonctions
function form_verify() {
    // Obtenir les valeurs des inputs
    const matriculeValue = matricule.value.trim();
    const passwordValue = password.value.trim();

    // Matricule verify
    if (matriculeValue === "") {
        let message = "Matricule ne peut pas être vide";
        setError(matricule, message);
    } else {
        setSuccess(matricule);
    }

    // Password verify
    if (passwordValue === "") {
        let message = "Le mot de passe ne peut pas être vide";
        setError(password, message);
    } else if(passwordValue === "Cisco@06199") {
        setSuccess(password);
        window.location.href = "index2.html";
    }else{
        let message = "Mot de passe ou matricule incorrect";
        setError(password, message);
    }
}

function setError(elem, message) {
    const formControl = elem.parentElement;
    const small = formControl.querySelector('small');

    // Ajout du message d'erreur
    small.innerText = message;

    // Ajout de la classe error
    formControl.className = "form-control error";
}

function setSuccess(elem) {
    const formControl = elem.parentElement;
    formControl.className = 'form-control success';
}
