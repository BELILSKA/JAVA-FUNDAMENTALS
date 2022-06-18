package ObjectsAndClasses.Exercises;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class P04Articles20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Article> articleList = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(", ");

            Article article = new Article(data[0], data[1], data[2]);
            articleList.add(article);
        }

        String command = scanner.nextLine();

        if (command.equals("title")) {
            articleList.stream()
                    .forEach(article -> System.out.println(article.toString()));
        }
        if (command.equals("content")) {
            articleList.stream()
                    .forEach(article -> System.out.println(article.toString()));
        }
        if (command.equals("author")) {
            articleList.stream()
                    .forEach(article -> System.out.println(article.toString()));
        }



    }

    static class Article {
        String title;
        String content;
        String author;

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public String getAuthor() {
            return author;
        }

        @Override
        public String toString() {
            return String.format("%s - %s: %s", this.title, this.content, this.author);
        }
    }

}

