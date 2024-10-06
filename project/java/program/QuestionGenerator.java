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
    
    public static void main(String[] args)
    {
        String bonneReponseTexte = "Bonne réponse";

        // Mauvaises réponses
        String mauvaiseReponseTexte1 = "Mauvaise réponse 1";
        String mauvaiseReponseTexte2 = "Mauvaise réponse 2";
        String mauvaiseReponseTexte3 = "Mauvaise réponse 3";

                List<String> reponses = new ArrayList<>();
        reponses.add(formatButton(bonneReponseTexte, true)); // True pour la bonne réponse (button)
        reponses.add(formatButton(mauvaiseReponseTexte1, false)); // False pour mauvaise réponse (link)
        reponses.add(formatButton(mauvaiseReponseTexte2, false));
        reponses.add(formatButton(mauvaiseReponseTexte3, false));

        genQuestion(2, List.of("","","",""), List.of("","","",""), List.of("","","",""), reponses);
    }

    private static void genQuestion(int lvl, List<String> problems, List<String> setLanguages, List<String> codes, List<String> reponsesListed)
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

        writeQuestion(quest1, lvl, problems.get(0), setLanguages.get(0), codes.get(0), reponsesListed);
        writeQuestion(quest2, lvl, problems.get(1), setLanguages.get(1), codes.get(1), reponsesListed);
        writeQuestion(quest3, lvl, problems.get(2), setLanguages.get(2), codes.get(2), reponsesListed);
        writeQuestion(quest4, lvl, problems.get(3), setLanguages.get(3), codes.get(3), reponsesListed);
    }

    private static void writeQuestion(File questIn, int lvl, String problem, String setLanguage, String code, List<String> reponses)
    {
        Collections.shuffle(reponses);

        if(!questIn.exists())
        {
			try(FileWriter writer = new FileWriter(questIn))
			{
				BufferedWriter buffer = new BufferedWriter(writer);				
				
				buffer.write("<!DOCTYPE html>\r\n" + //
                                        "<html lang=\"fr\">\r\n" + //
                                        "    <head>\r\n" + //
                                        "      <title> Question "+lvl+" </title>\r\n" + //
                                        "      <link rel=\"icon\" href=\"textures/logo.png\" type=\"image/png\">\r\n" + //
                                        "      <meta charset=\"utf-8\">\r\n" + //
                                        "      <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                                        "      <link rel=\"stylesheet\" type=\"text/css\" href=\"css/index.css\">\r\n" + //
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
                                        "            const pages = [\"2/quest1.html\", \"2/quest2.html\", \"2/quest3.html\", \"2/quest4.html\"];\r\n" + //
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