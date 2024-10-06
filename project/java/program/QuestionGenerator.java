package program;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class QuestionGenerator
{
    private QuestionGenerator() {}
    //private static final char LINE_NEW = '\n';
    
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
        List<String> reponses1 = List.of(
        formatButton("Division par 0 impossible", true), // True pour la bonne réponse (button)
        formatButton("Méthode main non correcte", false), // False pour mauvaise réponse (link)
        formatButton("Changement de type de int à double", false),
        formatButton("Impression console incorrecte", false));

        questions.add("Quel type de variable régit les conditions suivantes");
        languages.add("java");
        codes.add("void a()\r\n" + //
                        "    {\r\n" + //
                        "        int a = 45;\r\n" + //
                        "        int b = 46;\r\n" + //
                        "\r\n" + //
                        "        if(b > a)\r\n" + //
                        "        {\r\n" + //
                        "            System.out.println(\"B est plus grand\");\r\n" + //
                        "        }\r\n" + //
                        "        else\r\n" + //
                        "        {\r\n" + //
                        "            System.out.println(\"A est plus grand\");\r\n" + //
                        "        }\r\n" + //
                        "    }");
        List<String> reponses2 = List.of(
            formatButton("Boolean", true), // True pour la bonne réponse (button)
            formatButton("Integer", false), // False pour mauvaise réponse (link)
            formatButton("Double", false),
            formatButton("Condition", false));

        questions.add("Que produit ce programme sql");
        languages.add("sql");
        codes.add("SELECT * FROM table1;");
        List<String> reponses3 = List.of(
                formatButton("Affiche toute les lignes et colonnes de la table1", true), // True pour la bonne réponse (button)
                formatButton("Affiche toute les tables de la base de données", false), // False pour mauvaise réponse (link)
                formatButton("Créer une table", false),
                formatButton("Modifie une table", false));
        
        questions.add("Que font les balise h en html");
        languages.add("html");
        codes.add("<h1>Titre de l'onglet</h1>");
        List<String> reponses4 = List.of(
                formatButton("Affiche un texte sur la page html", true), // True pour la bonne réponse (button)
                formatButton("Affiche un titre à l'onglet html", false), // False pour mauvaise réponse (link)
                formatButton("Affiche une boîte de dialogue sur la page html", false),
                formatButton("Change l'url d'une page html", false));

        genQuestion(2, questions, languages, codes, reponses1, reponses2, reponses3, reponses4);
    }

    public static void main(String[] args)
    {
        lvl2();
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
                FileWriter writer = new FileWriter(questIn);
				BufferedWriter buffer = new BufferedWriter(writer);				
				
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
                                        "\r\n" + //
                                        "        <pre><code class=\"language-"+setLanguage+"\">\r\n" + //
                                        "            "+ code + //
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
                                        "            const pages = [\""+(lvl+1)+"/quest1.html\", \""+(lvl+1)+"/quest2.html\", \""+(lvl+1)+"/quest3.html\", \""+(lvl+1)+"/quest4.html\"];\r\n" + //
                                        "            document.getElementById('randomPageButton').onclick = function() {\r\n" + //
                                        "                const randomPage = pages[Math.floor(Math.random() * pages.length)];\r\n" + //
                                        "                window.location.href = randomPage;\r\n" + //
                                        "            };\r\n" + //
                                        "        </script>\r\n" + //
                                        "  </body>\r\n" + //
                                        "</html>");
				
				buffer.close();
				writer.close();
				questIn.createNewFile();
                System.out.println("Fichier " + questIn.getName() + " à été généré !");
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}   
        }
    }

    private static String formatButton(String texte, boolean isCorrect) {
        if (isCorrect) {
            // Si c'est la bonne réponse, on retourne un bouton
            return "<button class=\"button\" id=\"randomPageButton\"><h1>" + texte + "</h1></button>";
        } else {
            // Sinon, on retourne un lien
            return "<a href=\"perdu.html\" class=\"button-link\"><h1>" + texte + "</h1></a>";
        }
    }

}