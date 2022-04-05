<html>
<head>
	<link rel="stylesheet" href="./css/style.css" />
</head>
<body>
	<!-- bloc qui affiche le message de confirmation après création de l'avis avec succès -->
	<p class="message-confirmation">${messageConfirmation}</p>
	
	<!-- bloc qui affiche l'éventuel message d'erreur -->
	<p class="message-erreur">${messageErreur}</p>
	
	<form action="./" method="POST">		
		<label>Note : </label>
		<input type="number" name="note" /> <br /><br />
		<textarea name="description" placeholder="description" cols="20" rows="10"></textarea><br /><br />
		
		<button>Ajouter</button>
	</form>
</body>
</html>