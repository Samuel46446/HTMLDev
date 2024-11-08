// Initialiser les scores dans localStorage si ce n'est pas déjà fait
if (!localStorage.getItem('javaPoint')) localStorage.setItem('javaPoint', 0);
if (!localStorage.getItem('cppPoint')) localStorage.setItem('cppPoint', 0);
if (!localStorage.getItem('pythonPoint')) localStorage.setItem('pythonPoint', 0);
if (!localStorage.getItem('webPoint')) localStorage.setItem('webPoint', 0);
if (!localStorage.getItem('sqlPoint')) localStorage.setItem('sqlPoint', 0);

history.forward();

function bad(nextPage)
{
    setTimeout(function() {
        window.location.href = nextPage;
    }, 1);
}

// Fonction pour ajouter un point et rediriger vers la page suivante
function addPoint(language, nextPage) {
    // Incrémenter le score dans localStorage
    let currentScore = parseInt(localStorage.getItem(language + 'Point'), 10) || 0;
    localStorage.setItem(language + 'Point', currentScore + 1);

    // Mettre à jour l'affichage du score sur la page actuelle
    updateScores(language);

    // Redirection après un léger délai pour afficher le score mis à jour
    setTimeout(function() {
        window.location.href = nextPage;
    }, 1);
}

// Fonction pour mettre à jour l'affichage des scores
function updateScores(language) {
    const scoreElement = document.getElementById(language + "Score");
    if (scoreElement) { // Vérifie si l'élément existe dans le HTML
        scoreElement.innerText = localStorage.getItem(language + 'Point');
    }
}

function arrow(language, nextPage, pageIndex)
{
    let currentScore = parseInt(localStorage.getItem(language + 'Point'), 10) || 0;
    
    if(currentScore != 0 && pageIndex == currentScore)
    {
        localStorage.setItem(language + 'Point', currentScore - 1);
    }
    else
    {
        localStorage.setItem(language + 'Point', currentScore);
    }

    //updateScores(language);

    setTimeout(function() {
        window.location.href = nextPage;
    }, 1);
}

// Appel initial pour afficher les scores au chargement de la page
updateScores('java');
updateScores('cpp');
updateScores('python');
updateScores('web');
updateScores('sql');