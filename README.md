# RPG Game Project

## Description
Ce projet de jeu RPG me permet de découvrir les Design Patterns et leurs utilisations en java.

## Features
- Creation de personages : Warrior, Healer, Wizard
- Création d'équipes
- Attaque de personnages
- Decorateur de personnage : Armure, Invincible
- Pour ce qui est des effets, il y en a 3 : Heal, Damage et Buff. Heal rajoute des points de vies, Damage  enlève des points de vie et buff rajoute des points selon l'attribut : force, sagesse et intelligence.
- États des personnages : Normal, Apeuré, Mort, CheatMode

Pour résumer : 
**Warior** prends +10 avec Heal, -1 avec Damage et sa force augmente d'un entier entre 0 et 2 compris au hasard avec Buff.
**Healer** prends +10 avec Heal, -3 avec Damage et sa sagesse augmente d'un entier entre 0 et 6 compris au hasard avec Buff.
**Wizard** prends +5 avec Heal, -2 avec Damage et son intelligence augmente d'un entier entre 0 et 4 compris au hasard avec Buff.

## Design Patterns Used

Partie 1:

- _Singleton_ : Le D.P Singleton est utilisé pour la configuration du jeu, qui est unique et doit être accessible partout. On retrouve ce pattern dans le fichier GameConfiguration.java. Ainsi le constructeur est private et la méthode getInstance() permet de récupérer l'instance unique de la classe et elle est static car l'intance est unique.
- 
- _Factory Method_ : Le D.P Factory Method est utilisé  pour la création des personnages. L'interface CharacterFactory permet de définir des méthodes qui seront implémentées par les classes comme : HealerCreator.java, WarriorCreator.java, WizardCreator.java. Ainsi, on peut créer des personnages de type Healer, Warrior ou Wizard.

- _Prototype_ : Le D.P Prototype est utilisé pour cloner une équipe de personnages. L'interface Prototype permet de définir une méthode clone() qui sera implémentée par la classe Team.java. Il y a 3 constructeurs dans cette classe. Il y a le premier, auquel on donne un nom (type : String), qui construit une équipe vide. Il y a un second constructeur qui permet de cloner une équipe, on lui donne donc une équipe en paramètre. Enfin, il y a un troisième constructeur qui permet de créer une équipe avec des personnages déjà existants.

- _Builder_ : Le D.P Builder est utilisé pour créer des équipes comme on le souhaite. La classe Builder permet par exemple d'ajouter un joueur a une équipe ou d'ajouter un nom. 

- _Visitor_ : Le D.P Visitor est utilisé pour effectuer des opérations sur les personnages. Il y a une interface CharacterVisitor qui permet de définir des méthodes qui seront implémentées par les classes comme : BuffVisitor.java, DebuffVisitor.java, HealVisitor.java. Dans chacune de ces classes, sera traité les types de personnages différents et les méthodes de l'interface définiront comment agissent les effets sur ces personnages.

 
Partie 2:

- _Strategy_ : Le D.P Strategy est utilisé pour les attaques et les prises de dégats des personnages. Nous avons une interface Strategy qui définit 2 méthodes (ou algorithmes) qui permettent de caculer les dégats réçus et les dégats infligés. Il y a ensuite 3 classes qui implémentent cette interface : AggressiveStrategy.java, DefensiveStrategy.java, NormalStrategy.java. Selon la classe et donc selon le mode de jeu du joueur, les dégats infligés et reçus seront différents. Par exemple, avec la classe AggressiveStrategy, les dégats infligés seront plus importants de 8points. La classe GameCharacter utilise les stratégies pour calculer les dégats infligés et reçus par chaque personnage qui attaque ou qui est attaqué.

- _Observer_ : Le D.P Observer est utilisé pour notifier des observateurs lorsqu'un personnage est mort. Il y a une interface Observer qui définit la méthode update(), qui sera appelé. Il y a une deuxième interface Subject qui définit les méthodes pour ajouter et supprimer des observateurs. La classe GameCharacter implémente Subject et permet d'ajouter et de supprimer des observateurs. 


Partie 3:

- _Decorator_ : Le D.P Decorator est utilisé pour ajouter des améliorations aux personnages. Par exemple avec ArmoredDecorator, le personnage prends moins de dégats. Avec le decorator InvicibleDecorator, le personnage à son niveau de santé qui ne peut pas descendre en dessous de 20/100. Le personnage peut cumuler les améliorations. Les classes Decorator implémentent GameCharacter car ce sont des personnages améliorés. Dans chacun des fichiers, il faut rédefinir toutes les méthodes de GameCharacter avec l'instance du character amélioré.


Partie 4:

- _Facade_ : Le D.P Facade permet de simplifier l'utilisation des classes en cachant la complexité du code.

- _Command_ : Le D.P Command est utilisé pour les actions du jeu. Il y a une classe abstraite Command qui définit 2 méthodes (execute et update). Il y a un invoker. C'est une classe qui gère une file d'attente de commandes. Il y a des sous classes de Command. Par exemple, AttackCommand.java, est une classe qui permet d'attaquer un personnage et ChangeStratCommand.java est une classe qui permet de chnager la stratégie d'un personnage. Ce D.P permet de représenter les actions du jeu comme des objets plutot que des méthodes. 

> Concrètement lorsque le joueur clique sur un bouton (receiver), cela rajoute l'action dans la liste d'actions de l'invoker. Le receiver va ensuite executer toutes les actions de sa liste. Quand une action est appelé, c'est la méthode execute() de la classe qui est appelée. AttackCommand execute la fonction attack() (dans execute) de la facade Game, qui fait appel à la méthode giveDamage() de la classe GameCharacter.


Partie 5:

- _State_ : Le D.P State est utilisé pour gérer les différents états du joueur. On a une classe abstraite State.java qui définit différentes méthodes.Cette classe a différente classes filles qui implémentent ces méthodes selon l'état du joueur. Par exemple, le joueur peut être dans un état normal, apeuré, mort ou encore en cheat mode. Une fois rentré dans un état, la fonction OnExitState() est appelé pour l'état que le joueur quitte et la fonction OnEnterState() est appelé pour l'état dans lequel entre le joueur. Quand un joueur reçoit des degats, selon son état de santé, il peut changer d'état. Par exemple, si le joueur a en dessous de 15 points de vie, il passe en état apeuré. Si le joueur a 0 points de vie, il passe en état de mort. Un easter egg est caché : si le joueur à exactement 1 point de vie, il passe en cheatmode et garde ce mode pendant 5 tours, grace a la fonction onUpdate(). Enfin, il y a la fonction onAttack de chaque état qui permet de modifier les dégats infligés par le joueur selon son état. Par exemple, dans giveDamage(), si le joueur est en état cheatmode, alors les degats infligés sont multipliés par 3.

## Tests
Les tests sont réalisés avec JUnit et Maven. Pour lancer les tests, il suffit de lancer la commande suivante : `mvn test`. (avec le binaire accessible dans le PATH).

- Le fichier **TeamTest.java** teste la creation d'équipe, l'insertion de personnages dans une équipe, la suppression de personnages dans une équipe, la clonage d'une équipe et enfin vérifie si une équipe contient un personnage. **(9/9 tests passés)**

- Le fichier **CharacterTest.java** teste la création de personnages, et l'initalisation des attributes. **(3/3 tests passés)**

- Le fichier **BuilderTest.java** teste la création d'équipe avec le builder. **(3/3 tests passés)**

- Le fichier **StrategiesTest.java** teste les différentes stratégies de jeu. **(2/2 tests passés)**

- Le fichier **BuffVisitorTest.java** teste les effets de buff sur les personnages. **(3/3 tests passés)**

- Le fichier **DamageVisitorTest** teste les effets de dégats sur les personnages. **(1/1 tests passés)**

- Le fichier **DecoratorTest** teste les améliorations des personnages. **(3/3 tests passés)**

- Le fichier **CommandTest** teste les commandes du jeu. **(4/4 tests passés)**

- Le fichier **StateTest** teste les différents états du personnages.  **(6/6 tests passés)**

Au total : **34/34 tests passés** (50/50 en vrai avec les tests à répétitions)

Temps passé sur le projet depuis le début : **17h de code** (update à 16H le 05/12) + **6h de reflexion** = **23h**