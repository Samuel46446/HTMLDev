package program;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public final class QuestionGenerator
{
    private QuestionGenerator() {}
    //private static final char LINE_NEW = '\n';
    //&lt; = <
    //&gt; = >

    private static void lvl10()
    {
        List<String> questions = new ArrayList<>();
        List<String> languages = new ArrayList<>();
        List<String> codes = new ArrayList<>();

        questions.add("Quelle est l'extension d'une librairie C++ ?");
        languages.add("cpp");
        codes.add("Lib.?");
        List<String> reponses1 = genRep("lib", 
        "cppLib", 
        "cLib", 
        "clib");

        questions.add("Quelle est l'extension d'une librairie java ?");
        languages.add("java");
        codes.add("Log4j.?");
        List<String> reponses2 = genRep(
        "jar",
        "class", 
        "lib", 
        "api");

        questions.add("Que fait cette boucle while python :");
        languages.add("python");
        codes.add("points=10\r\n" + //
                        "\r\n" + //
                        "while points > 0:\r\n" + //
                        "    somme=0\r\n" + //
                        "    for i in range(10):\r\n" + //
                        "        somme=somme+randDee()\r\n" + //
                        "    print(\"La somme des 10 lancer de dés est de : \"+str(somme))\r\n" + //
                        "    if somme%2 == 0:\r\n" + //
                        "        points=points+1\r\n" + //
                        "        print(\"Vous gagnez 1 point\")\r\n" + //
                        "    else:\r\n" + //
                        "        points = points - 2\r\n" + //
                        "    print(\"Vous possédez : \" + str(points) + \" points !\")\r\n" + //
                        "    start=str(input(\"Appuyez sur entrer pour une nouvelle partie\"))\r\n" + //
                        "print(\"perdu\")");
        List<String> reponses3 = genRep(
        "Exécute un jeu de pile ou face tant que le joueur à plus de 0 points",
        "Exécute un jeu de pile ou face tant que le joueur n'a plus de points",
        "Exécute un jeu de pile ou face indéfiniment", 
        "Exécute un jeu de pile ou face qui ne s'arrête jamais à cause d'une erreur");
        
        questions.add("Parmis les propositions qu'est ce qui est obligatoirement présent dans une page html :");
        languages.add("html");
        codes.add("&lt;???&gt;");
        List<String> reponses4 = genRep("&lt;!DOCTYPE html&gt;",
        "&lt;head&gt;",
        "&lt;body&gt",
        "&lt;title&gt");

        genQuestion(10, questions, languages, codes, reponses1, reponses2, reponses3, reponses4);
    }
    
    public static void main(String[] args)
    {
        lvl3();
        lvl2();
        lvl4();
        lvl5();
        lvl6();
        lvl7();
        lvl8();
        lvl9();
        //lvl10();
    }

    private static void genQuestion(int lvl, List<String> problems, List<String> setLanguages, List<String> codes, List<String> reponsesListed1, List<String> reponsesListed2, List<String> reponsesListed3, List<String> reponsesListed4)
    {
        File directory = new File(System.getProperty("user.dir")+File.separator+"quests"+File.separator+lvl+File.separator);

        if(!directory.exists())
        {
            directory.mkdirs();
        }

        File quest1 = new File(directory.getAbsolutePath()+File.separator+"quest1.html");
        File quest2 = new File(directory.getAbsolutePath()+File.separator+"quest2.html");
        File quest3 = new File(directory.getAbsolutePath()+File.separator+"quest3.html");
        File quest4 = new File(directory.getAbsolutePath()+File.separator+"quest4.html");

        writeQuestion(quest1, lvl, problems.get(0), setLanguages.get(0), codes.get(0), reponsesListed1);
        writeQuestion(quest2, lvl, problems.get(1), setLanguages.get(1), codes.get(1), reponsesListed2);
        writeQuestion(quest3, lvl, problems.get(2), setLanguages.get(2), codes.get(2), reponsesListed3);
        writeQuestion(quest4, lvl, problems.get(3), setLanguages.get(3), codes.get(3), reponsesListed4);
    }

    private static void writeQuestion(File questIn, int lvl, String problem, String setLanguage, String code, List<String> reponses)
    {
        Collections.shuffle(reponses);

        if(!questIn.exists())
        {
			try
			{
				BufferedWriter buffer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(questIn), "UTF-8")
                );			
				
				buffer.write("<!DOCTYPE html>\r\n" + //
                                        "<html lang=\"fr\">\r\n" + //
                                        "    <head>\r\n" + //
                                        "      <title> Question "+lvl+" </title>\r\n" + //
                                        "      <link rel=\"icon\" href=\"../textures/logo.png\" type=\"image/png\">\r\n" + //
                                        "      <meta charset=\"utf-8\">\r\n" + //
                                        "      <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                                        "      <link rel=\"stylesheet\" type=\"text/css\" href=\"../css/index.css\">\r\n" + //
                                        "\r\n" + //
                                        "          <!-- Inclusion de Highlight.js -->\r\n" + //
                                        "    <link href=\"https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.7.0/styles/default.min.css\" rel=\"stylesheet\">\r\n" + //
                                        "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.7.0/highlight.min.js\"></script>\r\n" + //
                                        "\r\n" + //
                                        "    <!-- Lancer Highlight.js -->\r\n" + //
                                        "    <script>hljs.highlightAll();</script>\r\n" + //
                                        "\r\n" + //
                                        "    </head>\r\n" + //
                                        "    <body>\r\n" + //
                                        "\r\n" + //
                                        "        <div class=\"title\"><h2>Niveau "+lvl+"</h2></div>\r\n" + //
                                        "        <div class=\"question\"><h1>"+problem+" :</h1></div>\r\n" + //
                                        "\r\n<div class=\"home\"><a href=\"../index.html\" class=\"button-link\"><img src=\"../textures/home_button.png\" alt=\"\" width=50px height=50px></a></div>" + //
                                        "        <pre><code class=\"language-"+setLanguage+"\">\r\n" + //
                                       code + //
                                        "        </code></pre>\r\n" + //
                                        "            \r\n" + //
                                        "        <table>\r\n" + //
                                        "            <thead>\r\n" + //
                                        "                <th>\r\n" + //
                                        reponses.get(0) + //
                                        "                </th>\r\n" + //
                                        "                <th>\r\n" + //
                                        reponses.get(1)+ //
                                        "                </th>\r\n" + //
                                        "            </thead>\r\n" + //
                                        "            <thead>\r\n" + //
                                        "                <th>\r\n" + //
                                        reponses.get(2) + //
                                        "                </th>\r\n" + //
                                        "                <th>\r\n" + //
                                        reponses.get(3) + //
                                        "                </th>\r\n" + //
                                        "            </thead>\r\n" + //
                                        "        </table>\r\n" + //
                                        "        \r\n" + //
                                        "        <script>\r\n" + //
                                        "            const pages = [\"../"+(lvl+1)+"/quest1.html\", \"../"+(lvl+1)+"/quest2.html\", \"../"+(lvl+1)+"/quest3.html\", \"../"+(lvl+1)+"/quest4.html\"];\r\n" + //
                                        "            document.getElementById('randomPageButton').onclick = function() {\r\n" + //
                                        "                const randomPage = pages[Math.floor(Math.random() * pages.length)];\r\n" + //
                                        "                window.location.href = randomPage;\r\n" + //
                                        "            };\r\n" + //
                                        "        </script>\r\n" + //
                                        "  </body>\r\n" + //
                                        "</html>");
				
				buffer.close();
				questIn.createNewFile();
                System.out.println("Fichier " + questIn.getName() + " à été généré !");
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}   
        }
    }

    private static List<String> genRep(String repCorrect, String mauvaiseRep1, String mauvaiseRep2, String mauvaiseRep3)
    {
        return new ArrayList<>(List.of(
            formatButton(repCorrect, true), // True pour la bonne réponse (button)
            formatButton(mauvaiseRep1, false), // False pour mauvaise réponse (link)
            formatButton(mauvaiseRep2, false),
            formatButton(mauvaiseRep3, false)));
    }

    private static String formatButton(String texte, boolean isCorrect) {
        if (isCorrect) {
            // Si c'est la bonne réponse, on retourne un bouton
            return "<button class=\"button\" id=\"randomPageButton\"><h1>" + texte + "</h1></button>";
        } else {
            // Sinon, on retourne un lien
            return "<a href=\"../perdu.html\" class=\"button-link\"><h1>" + texte + "</h1></a>";
        }
    }

    private static void lvl9()
    {
        List<String> questions = new ArrayList<>();
        List<String> languages = new ArrayList<>();
        List<String> codes = new ArrayList<>();

        questions.add("Qu'est ce que la variable rA ?");
        languages.add("cpp");
        codes.add("int a = 10;\nint& rA = a;\n");
        List<String> reponses1 = genRep("une référence", 
        "un pointeur", 
        "une bibliothèque", 
        "un booléen");

        questions.add("Quelle mot clé permet de corriger le programme java suivant : ");
        languages.add("java");
        codes.add("? Fruits\n{\n    BANANE, FRAISE, FRAMBOISE, POIRE\n}");
        List<String> reponses2 = genRep(
        "enum",
        "class", 
        "interface", 
        "def");

        questions.add("Que fait ce programme python ?");
        languages.add("python");
        codes.add("r=randInt(1, 128)\nprint(r)");
        List<String> reponses3 = genRep(
        "Affiche un entier aléatoire entre 1 et 128",
        "Affiche un entier choisis",
        "Affiche un double aléatoire entre 1 et 128", 
        "Affiche le nom d'une classe");
        
        questions.add("Quelle mot clé permet de corriger le programme C# suivant :");
        languages.add("cs");
        codes.add("?(a)\n{\n    case 1:\n        print(a);\n    break;\n}");
        List<String> reponses4 = genRep("switch",
        "if",
        "else",
        "verif");

        genQuestion(9, questions, languages, codes, reponses1, reponses2, reponses3, reponses4);
    }

    private static void lvl8()
    {
        List<String> questions = new ArrayList<>();
        List<String> languages = new ArrayList<>();
        List<String> codes = new ArrayList<>();

        questions.add("Avec la classe java suivante comment créer t'on l'objet");
        languages.add("java");
        codes.add("public class Train\r\n" + //
                        "{\r\n" + //
                        "    private String d,a;\r\n" + //
                        "    private String t;\r\n" + //
                        "    \r\n" + //
                        "    public Train(String depart, String arrive, String time)\r\n" + //
                        "    {\r\n" + //
                        "        this.d=depart;\r\n" + //
                        "        this.a=arrive;\r\n" + //
                        "        this.t=time;\r\n" + //
                        "    }\r\n" + //
                        "}");
        List<String> reponses1 = genRep("Train train = new Train(\"Paris\", \"Marseille\", \"12h00\");", 
        "Train train = new Train();", 
        "Train train = Train();", 
        "Train train = Train(\"Paris\", \"Marseille\", \"12h00\");");

        questions.add("Quel mot clé est necessaire dans cette méthode pyhton :");
        languages.add("py");
        codes.add("class Personne:\n" + //
                        "    def __init__(?, nom, age):\n" + //
                        "        ?.nom = nom \n" + //
                        "        ?.age = age \n" + //
                        "");
        List<String> reponses2 = genRep(
        "self",
        "def", 
        "bool", 
        "new");

        questions.add("Comment acceder à une classe(titre) HTML via une feuille de style ?");
        languages.add("css");
        codes.add("???? {\n    color: blue;\n}");
        List<String> reponses3 = genRep(
        ".titre",
        "classget(titre)",
        "titre.class", 
        "div>titre");
        
        questions.add("En C++ comment déclare t-on dans ce cas pour rendre publique cette fonction func ?");
        languages.add("cpp");
        codes.add("class Somme\n{\n    ????\n    void func()\n    {       std::cout << \"Bienvenue dans la fonction func\" << std::endl;\n    }\n};");
        List<String> reponses4 = genRep("public:",
        "public void func()",
        "public Somme()",
        "public ->");

        genQuestion(8, questions, languages, codes, reponses1, reponses2, reponses3, reponses4);
    }

    private static void lvl7()
    {
        List<String> questions = new ArrayList<>();
        List<String> languages = new ArrayList<>();
        List<String> codes = new ArrayList<>();

        questions.add("Java est un language qu'on qualifie");
        languages.add("java");
        codes.add("public static void main()\n{\n    System.out.println(\"Hello world\");\n}");
        List<String> reponses1 = genRep("d'orienter objet", 
        "d'orienter programmation", 
        "d'orienter web", 
        "d'orienter jeu");

        questions.add("En python ont peut utiliser des pointeurs !");
        languages.add("py");
        codes.add("a=0\nb*=&a");
        List<String> reponses2 = genRep(
        "Non",
        "Oui", 
        "Peut être", 
        "Je ne sais pas");

        questions.add("Html est un language utilisable seulement");
        languages.add("html");
        codes.add("&lt;title&gt;Titre de l'onglet&lt;/title&gt;");
        List<String> reponses3 = genRep(
        "Pour créer des pages web",
        "Pour créer des application",
        "Pour créer des feuilles de style", 
        "Pour créer des programmes informatique");
        
        questions.add("Le C++ est un language qu'on qualifie de : ");
        languages.add("cpp");
        codes.add("int main()\n{\n    std::cout << \"Hello world\" << std::endl;\n}");
        List<String> reponses4 = genRep("Compilé",
        "Objet",
        "Interprété",
        "Balisage");

        genQuestion(7, questions, languages, codes, reponses1, reponses2, reponses3, reponses4);
    }

    private static void lvl5()
    {
        List<String> questions = new ArrayList<>();
        List<String> languages = new ArrayList<>();
        List<String> codes = new ArrayList<>();

        questions.add("Quel variable permet de supprimer la table sql suivante :");
        languages.add("sql");
        codes.add("? TABLE SCORE;");
        List<String> reponses1 = genRep("DROP", 
        "DELETE", 
        "FREE", 
        "DEL");

        questions.add("Que retourne cette fonction java ?");
        languages.add("java");
        codes.add("public int func(int nbr)\r\n" + //
                        "{\r\n" + //
                        "    return ?;\r\n" + //
                        "}");
        List<String> reponses2 = genRep(
        "Un entier (int)",
        "Un double (double)", 
        "Un Booléen (boolean)", 
        "Une chaîne de caractère (String)");

        questions.add("Que signifie rgb pour cette fonction css qui définie la couleur de l'arrière plan ?");
        languages.add("css");
        codes.add("body {\r\n" + //
                        "    background-color: rgb(31, 30, 32);\r\n" + //
                        "}\r\n" + //
                        "");
        List<String> reponses3 = genRep(
        "Les couleurs Red Green Blue servant à l'encodage numérique",
        "Les couleurs Red Gray Blue servant à l'encodage numérique",
        "Les couleurs Rose Gray Blue servant à l'encodage numérique", 
        "Les couleurs Blue White Red servant à l'encodage numérique");
        
        questions.add("Quel caractère permet de faire un commentaire en python");
        languages.add("python");
        codes.add("? Mon commentaire génial, cette fonction fait ça bla bla.");
        List<String> reponses4 = genRep("#",
        "//", 
        "&lt;!-- --&gt;", 
        "/* */");

        genQuestion(5, questions, languages, codes, reponses1, reponses2, reponses3, reponses4);
    }

    private static void lvl4()
    {
        List<String> questions = new ArrayList<>();
        List<String> languages = new ArrayList<>();
        List<String> codes = new ArrayList<>();

        questions.add("Que produit le programme php suivant :");
        languages.add("php");
        codes.add("&lt;?php\r\n" + //
                        "    for(int i = 0; i < 5; i++)\r\n" + //
                        "    {\r\n" + //
                        "        print(i);\r\n" + //
                        "    }\r\n" + //
                        "?&gt;");
        List<String> reponses1 = genRep("affiche des entiers de 0 à 4", 
        "affiche des entiers de 1 à 4", 
        "affiche 6 entiers ", 
        "affiche des doubles");

        questions.add("Qu'est qu'une variable final ?");
        languages.add("java");
        codes.add("public final int PRIX = 100; //100 €");
        List<String> reponses2 = genRep(
        "Une variable qu'on ne peut plus modifié après initialisation",
        "Une variable qu'on peut modifié après initialisation", 
        "Une variable qui convertie un entier en double", 
        "Une variable comme une autre");

        questions.add("Que fait une fonction void");
        languages.add("cpp");
        codes.add("void func();");
        List<String> reponses3 = genRep("S'éxécute mais ne retourne rien",
        "Éxécute et retourne un type",
        "Éxécute et stocke des variables", "N'est pas correct");
        
        questions.add("Quel mot-clé pour déclarer une fonction en python ?");
        languages.add("python");
        codes.add("? func(i):\r\n" + //
                        "        print(i)");
        List<String> reponses4 = genRep("def",
        "void", 
        "f", 
        "function");

        genQuestion(4, questions, languages, codes, reponses1, reponses2, reponses3, reponses4);
    }

    private static void lvl3()
    {
        List<String> questions = new ArrayList<>();
        List<String> languages = new ArrayList<>();
        List<String> codes = new ArrayList<>();

        questions.add("Quel est l'extension des fichiers java ?");
        languages.add("java");
        codes.add("Program.?");
        List<String> reponses1 = genRep(".java", 
        ".jar", 
        ".javac", 
        ".class");

        questions.add("Quel est l'extension des fichiers de feuilles de style ?");
        languages.add("java");
        codes.add("Style.?");
        List<String> reponses2 = genRep(".css", ".fss", 
        ".style", ".paper");

        questions.add("Quel est l'extension des fichiers C++");
        languages.add("cpp");
        codes.add("Jeu.?");
        List<String> reponses3 = genRep(".cpp",
        ".c",
        ".cplusplus", ".c++");
        
        questions.add("Quel est l'extension des fichiers python");
        languages.add("python");
        codes.add("Snake.?");
        List<String> reponses4 = genRep(".py",
        ".python", 
        ".p", 
        ".serpent");

        genQuestion(3, questions, languages, codes, reponses1, reponses2, reponses3, reponses4);
    }

    private static void lvl2()
    {
        List<String> questions = new ArrayList<>();
        List<String> languages = new ArrayList<>();
        List<String> codes = new ArrayList<>();

        questions.add("Quel est l'erreur dans ce programme C");
        languages.add("c");
        codes.add("int main (void)\r\n" + //
                  "{\r\n" + //
                        "    int i = 4 / 0;\r\n" + //
                        "    printf(\"Div : %d\", i);\r\n" + //
                        "    return 0;\r\n" + //
                        "}");
        List<String> reponses1 = genRep("Division par 0 impossible", 
        "Méthode main non correcte", 
        "Changement de type de int à double", 
        "Impression console incorrecte");
        
        questions.add("Quel type de variable régit les conditions suivantes");
        languages.add("java");
        codes.add("void a()\r\n" + //
                        "{\r\n" + //
                        "    int a = 45;\r\n" + //
                        "    int b = 46;\r\n" + //
                        "\r\n" + //
                        "    if(b > a)\r\n" + //
                        "    {\r\n" + //
                        "        System.out.println(\"B est plus grand\");\r\n" + //
                        "    }\r\n" + //
                        "    else\r\n" + //
                        "    {\r\n" + //
                        "        System.out.println(\"A est plus grand\");\r\n" + //
                        "    }\r\n" + //
                        "}");
        List<String> reponses2 = genRep("Boolean", "Integer", 
        "Double", "Condition");

        questions.add("Que produit ce programme sql");
        languages.add("sql");
        codes.add("SELECT * FROM table1;");
        List<String> reponses3 = genRep("Affiche toute les lignes et colonnes de la table1",
        "Affiche toute les tables de la base de données",
        "Créer une table", "Modifie une table");
        
        questions.add("Que font les balises \"h\" en html");
        languages.add("html");
        codes.add("&lt;h1&gt;Titre de l'onglet&lt;/h1&gt;");
        List<String> reponses4 = genRep("Affiche un texte sur la page html",
        "Affiche un titre à l'onglet html", 
        "Affiche une boîte de dialogue sur la page html", 
        "Change l'url d'une page html");

        genQuestion(2, questions, languages, codes, reponses1, reponses2, reponses3, reponses4);
    }

    private static void lvl6()
    {
        List<String> questions = new ArrayList<>();
        List<String> languages = new ArrayList<>();
        List<String> codes = new ArrayList<>();

        questions.add("Quel variable est necessaire pour enregistrer cette clé étrangère ?");
        languages.add("sql");
        codes.add("    CONSTRAINT fk_ID_Menu ?(ID_Menu) REFERENCES MENU(ID_Menu)");
        List<String> reponses1 = genRep("FOREIGN KEY", 
        "PRIMARY KEY", 
        "FINAL KEY", 
        "FINLAND KEY");

        questions.add("Quel librairie doit ont généralement inclure en C++ ?");
        languages.add("cpp");
        codes.add("#include ?");
        List<String> reponses2 = genRep(
        "&lt;iostream&gt;",
        "&lt;string&gt;", 
        "&lt;ctime&gt;", 
        "&lt;system&gt;");

        questions.add("A quoi peut servir la balise \"a\" en html ?");
        languages.add("html");
        codes.add("&lt;a ????&gt;TRUC&lt;/a&gt;");
        List<String> reponses3 = genRep(
        "Ajouter un lien pour nous rediriger vers une autre page",
        "Ajouter un texte avec les couleurs de notre choix",
        "Ajouter une image", 
        "Ajouter un tableau");
        
        questions.add("Que signifie ce caractère ajouter après un entier (*) ?");
        languages.add("c");
        codes.add("int a = 10;\nint* iA = &a;");
        List<String> reponses4 = genRep("Un pointeur",
        "Une référence",
        "Un entier",
        "Une structure");

        genQuestion(6, questions, languages, codes, reponses1, reponses2, reponses3, reponses4);
    }
}