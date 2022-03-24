# CS312 TP01 

  * Sujet initial : I. Parissis, etc
  * Typographié par Laure Gonnord
  * Version: 2022.01
  * Pas de rendu pour ce TP
  * Travail à effectuer sous Linux (2séances, 3 heures)

## Objectif

* Comprendre la compilation et l'exécution de programmes Java
* Comprendre les variables d'environnement associées (classpath)
* Première initiation aux packages.
* Documentation
* (opt) Écriture / modification de classes


## Startup

Récupérez le répertoire associé à ce TP: 
* soit en faisant un git pull après un clone initial.
* soit en récupérant l'archive associée à ce dépot git à partir de la page web.

Les fichiers sont pour ce TP dans [TP01/_code](TP01/_code).

##  Compilation et exécution d'un programme Java

On fait l'hypothèse que vous avez récupéré les fichiers du TP dans `_code/` et que vous y avez ouvert un terminal.

1. Regardez le contenu  du programme source `Premice.java` (vous pouvez utiliser la commande `cat` dans votre terminal).

2. Exécutez la commande `javac` sans paramètre pour obtenir l'aide en ligne.

3. Compilez le programme `Premice.java`. Vérifiez qu'un fichier `.class` a bien été produit dans le même répertoire. Exécutez la même commande avec l'option -verbose et observez les informations générées durant le processus de compilation. Ces informations vous en apprendront plus sur la manière dont se déroule la compilation.

4. Exécutez le programme ainsi compilé avec la commande `java`.

5. Modifiez ce programme de manière à ce qu'il provoque l'affichage suivant :
```
BONJOUR CECI EST MON PREMIER PROGRAMME JAVA
```
Compilez, exécutez! **Il ne sera pas rappelé de tester, mais vous devez toujours le faire**

6. Modifiez ce programme de manière à ce qu'il affiche 
```
JE SOUSSIGNÉ(E), xx,
```
où xx est votre nom que vous passerez comme premier argument de la (ligne de) commande.

## Répertoires et _classpath_

8. Recompilez le programme précédent, en vous plaçant cette fois-ci dans le répertoire parent, et visualisez l'endroit où le fichier .class a été produit.

9. Créez maintenant deux sous-répertoires de `_code`, que vous appellerez `src` et `build`. Placez le fichier Premice.java dans le premier et, en utilisant l'option -d de javac, faites en sorte que le fichier .class soit produit dans le second.

On vous fournit un répertoire Visages, avec un sous-répertoire `Visages/src`, contenant les fichiers suivants : `VisageRond.java`, `Dessin.java` et `AppliVisage1.java`

10. Regardez ces fichiers et devinez ce que fait l'application Java.

11. Créez un répertoire build en parallèle de `src` ("à côté").

12. Placez-vous dans le répertoire `src` et compilez l'application `AppliVisage1` en utilisant la commande `javac -d ../build AppliVisage1.java` pour placer les fichiers .class dans le répertoire build.

13. Placez-vous dans le répertoire `build` et constatez que l'ensemble des classes nécessaires a été compilé.

14. Depuis ce répertoire build exécutez l'application `AppliVisage1`. Faîtes CTRL-C sur la ligne de commandes pour arrêter l'application.

15. Replacez-vous à la racine du  répertoire Visages et exécutez l'application `AppliVisage1` en utilisant l'option `-classpath build` (ou `-cp`) pour indiquer à `java` où trouver les classes à charger.

16. Déplacer le fichier `AppliVisage1.class` du répertoire build vers le répertoire Visages (son répertoire parent)

17. Essayez de ré-exécuter java `AppliVisage1`, que constatez-vous ?

Un peu de doc:

> Le processus de compilation conduit (en cas de réussite) à la génération d'un fichier .class contenant le code interprétable de la classe spécifiée en entrée. Lorsque le compilateur détecte une instruction où l'utilisation d'une autre classe est faite (appel de méthode, accès à un attribut), il tente de se procurer le fichier .class associé à cette classe afin de vérifier simplement que ladite classe est correctement utilisée (i.e. l'attribut ou la méthode existent, sont visibles,...). Le compilateur sait implicitement localiser ces fichiers pour les classes des bibliothèques fournies avec le SDK (par exemple la classe System). Pour les autres, et notamment celles écrites par les développeurs tiers, il utilise le contenu de la variable d'environnement `CLASSPATH` (qu'il est donc utile de bien initialiser et de rendre publique). La valeur de cette variable est une suite de chemins de recherche séparés par : (convention Linux) ou ; (convention DOS/Windows). L'ordre des chemins dans cette variable est important, le compilateur cessant de chercher lorsqu'il a trouvé un chemin le conduisant au fichier souhaité. Lorsque cette variable n'est pas définie, il est considéré par défaut que la recherche s'effectue uniquement dans le répertoire courant. 
> Lors de l'exécution d'une application, les classes sont chargées au fur et à mesure de leur première utilisation, en commençant par celle contenant le main. La machine virtuelle a donc besoin, comme le compilateur, d'obtenir les fichiers .class correspondant aux différentes classes. La variable d'environnement `CLASSPATH` est alors utilisée à cette fin, de la même manière. Il est cependant important d'avoir à l'esprit que le fichier .class utilisé par la machine virtuelle n'est pas forcément celui ayant été utilisé par le compilateur. Si le contenu de ces deux fichiers n'est pas identique, il peut survenir des erreurs lors de l'exécution.

18. Positionnez la variable d'environnement CLASSPATH de manière appropriée pour l'application AppliVisage1 et recompilez puis exécutez les classes sans utiliser, cette fois, l'option `-cp`. On pourra faire en deux temps, d'abord localement dans le terminal qui va lancer la commande, et ensuite dans le `bashrc`.

### Construction et utilisation de fichiers jar

Il est dans certains cas utile (notamment lorsque l’on transmet
l’application via le réseau) de regrouper au sein d’une archive
l’ensemble de classes d’une application ou d’une librairie. Une telle
archive a, en Java, un format normalisé et se dénomme un `jar`. Un outil
éponyme permet d’archiver des classes.

La syntaxe de la commande de création d’archive est la suivante : 
```
jar -cvf [nom du jar à créer] [fichiers à inclure]
``` 
Les fichiers à inclure sont désignés par leur nom uniquement.  Il est possible d’utiliser des jokers (par exemple A*.class) ou d’indiquer un nom de répertoire (ce qui aura pour effet d’inclure tous les fichiers du répertoire, en conservant la structure dans l’archive). L’outil `jar` considère comme répertoire de base celui à partir duquel il est exécuté, si l’on souhaite inclure des fichiers situés dans un autre répertoire, il faut spécifier avant leur nom le chemin conduisant au répertoire avec l’option `-C`.

Lorsque les fichiers `.class` sont archivés, il faut que la variable `CLASSPATH` contienne non pas le répertoire contenant l’archive jar mais le chemin désignant l’archive elle-même (il en est de même lorsque les classes sont archivées dans un zip, l’environnement Java supportant aussi ce format d’archive non standard).

19. Replacez-vous dans le répertoire `build` et construisez un fichier `Visages.jar`, que vous placerez dans le répertoire `Visages`, contenant les fichiers `.class`.

20. Positionnez correctement la variable `CLASSPATH` (elle doit contenir l’archive jar), replacez-vous dans le répertoire `Visages` et lancez à nouveau l'exécution.

Il est également possible d’exécuter directement une application contenue dans une archive jar avec 
l’option -jar de l’outil java. On utilise pour cela un fichier de métadonnées appelé `manifest`, de la façon suivante:

21. Editez un fichier `manifest` contenant uniquement la ligne `Main-Class: AppliVisage1` (attention, la ligne doit se terminer par un saut de ligne):
* Recréez l’archive en incluant le manifest avec l’option `-m` (syntaxe : `jar -cvmf [manifest] [jar] [fichiers]`)
* Exécutez directement l'application avec l’option `-jar` de java. 


### Outil javadoc

Le SDK fournit un outil de génération de documentation (avec pour
cible privilégiée le langage HTML) nommé javadoc et basé sur
l’utilisation de balises (tags) dans le code source. Vous pouvez
consulter la partie de la documentation en ligne traitant de cet outil
afin de vous familiariser avec les balises et les paramètres de la
ligne de commande. La finalité de cet outil est de fournir une
documentation pour chaque classe, détaillant notamment la
signification des attributs, des méthodes, des paramètres et valeurs
de retour.

Les commentaires JavaDoc s’insèrent toujours avant ce qu’ils sont
censés décrire, et peuvent mélanger du texte qui sera inséré tel quel
dans la documentation et des balises interprétées par l’outil. Il est
par exemple possible, en utilisant cette syntaxe, de préciser à quoi
sert la classe, qui en est l’auteur et quel est le numéro de version :

``` java
/**
* La classe Lampe ...
* @author S.Jean
* @version 1.0
*/
public class Lampe {...}
Il est aussi possible de préciser à quoi sert un attribut :
/**
* La puissance de la lampe
*/
public int puissance;
Il est également possible de préciser à quoi sert une méthode (ou un constructeur) :
/**
* Constructeur avec paramètre.
* @param p La puissance de la lampe.
*/
public Lampe(int p) {...}
/**
* Obtention de la puissance de la lampe.
* @return la puissance de la lampe.
*/
public int getPuissance() {...}
```

22. Pour comprendre le fonctionnement de cette application étudiez la documentation HTML des classes `VisageRond` et `Dessin` que vous générerez à partir des commentaires situés dans les fichiers sources de ces classes (regardez ces sources):
*  créez un répertoire docs dans le répertoire Visages
* depuis le répertoire src lancez la commande javadoc -d ../docs VisageRond.java Dessin.java. Les fichiers html de documentation sont générés dans le répertoire docs, le point d'entrée étant le fichier index.html.
* consultez cette documentation à l'aide d'un navigateur. 


###  Modification d'une classe simple (partie optionnelle)

23. Modifiez la classe VisageRond afin que la taille par défaut d'un visage soit de 100x100 au lieu de 50x50 et recompilez cette classe.

24. Ré-exécutez l'application AppliVisage1 en utilisant la même commande qu'au point 20., que constatez-vous?

25. Ré-exécutez l'application en utilisant la commande du point 12., que constatez-vous ? Justifiez vos constatations.

26. Sauvegardez dans le répertoire src le fichier : AppliVisage2.java

27. Placez-vous dans le répertoire src et compilez AppliVisage2 avec la commande `javac -d .. AppliVisage2.java` , corrigez les erreurs de compilation.

28. Exécuter l'application AppliVisage2, que constatez-vous ?

29. Corrigez et exécutez l'application AppliVisage2.

30. Consulter la documentation de  class Dialogue (voir dans l’aperçu des sections), refaites le point 7. en utilisant un Dialogue pour réaliser l’interaction.

31. Ajouter dans la classe VisageRond la méthode humeur qui admet un paramètre entier pouvant prendre 3 valeurs distinctes (TRANQUILLE, JOYEUX et TRISTE) et fixe l’expressivité du visage. Modifier la méthode « dessiner » en conséquence : dans l’état tranquille la bouche sera dessinée par un trait horizontal, joyeux par un demi-cercle inférieur et triste par un demi-cercle supérieur.

32. Reprendre la classe VisageRond en construisant une nouvelle classe Oeil pour représenter les caractéristiques d’un oeil. Modifier la classe VisageRond pour intégrer 2 objets de cette classe pour représenter les yeux du visage.

33. On souhaite améliorer le mécanisme de rebond du visage. Lorsque le visage atteindra un bord on appliquera les lois du rebond (sans perte d’énergie).
