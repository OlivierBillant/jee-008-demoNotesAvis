<html>
<head>
	<link rel="stylesheet" href="./css/style.css" />
</head>
<body>
	<!-- bloc qui affiche le message de confirmation apr�s cr�ation de l'avis avec succ�s -->
	<p class="message-confirmation">${messageConfirmation}</p>
	
	<!-- bloc qui affiche l'�ventuel message d'erreur -->
	<p class="message-erreur">${messageErreur}</p>
	
	<form action="./" method="POST">		
		<label>Note : </label>
		<input type="number" name="note" /> <br /><br />
		<textarea name="description" placeholder="description" cols="20" rows="10"></textarea><br /><br />
		
		<button>Ajouter</button>
	</form>
</body>
</html>