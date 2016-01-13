# Build-Spheres-of-Dyson
Create virtual spheres of dyson, alone or with a community // Help the humanity to prepare the real construction of these spheres

The current interface and the following text is in french. If your interested in this but not fluent in french, 
  please contact me (Mathieu ALTHUSER) @ mathieu.althuser@uha.fr or mathieu.althuser@gmail.com (I use the first one more frenquently)

  Version 0.0 (13/01/2016) : Création du ReadMe
  
  	Les classes et leurs usages :
  	
  		- BuildSpheresofDyson : le "main" il sert d'interface textuelle pour l'utilisateur
  		- CommandException : Exception utilisée en cas d'utilisation de commande inexistante ou mal écrite
  		- Coordinates : classe de coordonnnées 3D des satellites et des astres
  		- Corporation : classe de corporation (alliance économique de plusieurs joueurs)
  		- Interpret : classe qui interprète les commandes textuelles pour en effectuer les actions, elle est en cours d'amélioration et d'aggrandissement
  		- PanelDimensions : classe de gestion des dimensions des SwarmPart
  		- Player : classe de joueur qui détient une liste de Satellite
  		- Satellite : classe abstraite qui regroupe les méthodes et les données génériques des différents types de satellites
  		- Save : classe de sauvegarde et de chargement de sauvegarde
  		- Star : classe d'astre
  		- SwarmPart : premier type de satellite implémenté. Il s'agit de panneau solaire de "petite" taille faisant souvent parti d'un essaim plus conséquent (d'où le nom)
  		
  	Note : Désolé de ne pas avoir généré ce fichier plus tôt