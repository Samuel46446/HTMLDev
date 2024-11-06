// Initialiser les scores dans localStorage si ce n'est pas déjà fait
if (!localStorage.getItem('javaPoint')) localStorage.setItem('javaPoint', 0);
if (!localStorage.getItem('cppPoint')) localStorage.setItem('cppPoint', 0);
if (!localStorage.getItem('pythonPoint')) localStorage.setItem('pythonPoint', 0);
if (!localStorage.getItem('webPoint')) localStorage.setItem('webPoint', 0);
if (!localStorage.getItem('sqlPoint')) localStorage.setItem('sqlPoint', 0);

function bad(nextPage)
{
    setTimeout(function() {
        window.location.href = nextPage;
    }, 500);
}

// Fonction pour ajouter un point et rediriger vers la page suivante
function addPoint(language, nextPage) {
    // Incrémenter le score dans localStorage
    let currentScore = parseInt(localStorage.getItem(language + 'Point'), 10) || 0;
    localStorage.setItem(language + 'Point', currentScore + 1);

    // Mettre à jour l'affichage du score sur la page actuelle
    //updateScores();

    // Redirection après un léger délai pour afficher le score mis à jour
    setTimeout(function() {
        window.location.href = nextPage;
    }, 500);
}

// Fonction pour mettre à jour l'affichage des scores
function updateScores() {
    document.getElementById("javaScore").innerText = localStorage.getItem('javaPoint');
    document.getElementById("cppScore").innerText = localStorage.getItem('cppPoint');
    document.getElementById("pythonScore").innerText = localStorage.getItem('pythonPoint');
    document.getElementById("webScore").innerText = localStorage.getItem('webPoint');
    document.getElementById("sqlScore").innerText = localStorage.getItem('sqlPoint');
}

// Appel initial pour afficher les scores au chargement de la page
updateScores();