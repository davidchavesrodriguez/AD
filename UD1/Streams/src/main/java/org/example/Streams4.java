package org.example;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Flows4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Which page do you want to download?");
            URI uri = new URI(sc.nextLine());
            URL url = uri.toURL();

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            String contentType = connection.getContentType();
            int contentLength = connection.getContentLength();

            System.out.println("Content-Type: " + contentType);
            System.out.println("Content-Length: " + contentLength + " bytes");

            String extension = getExtensionFromContentType(contentType);
            String fileName = "src/main/resources/page" + extension;

            try (InputStream inputStream = connection.getInputStream();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                 FileOutputStream fileOutputStream = new FileOutputStream(fileName);
                 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    writer.write(line);
                    writer.newLine();
                }

                System.out.println("Page downloaded and saved as: " + fileName);

            } catch (IOException e) {
                throw new RuntimeException("An error occurred during download or file writing", e);
            }

        } catch (URISyntaxException | MalformedURLException e) {
            throw new RuntimeException("Invalid URI", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getExtensionFromContentType(String contentType) {
        if (contentType == null) return ".txt";
        if (contentType.contains("text/html")) return ".html";
        if (contentType.contains("text/plain")) return ".txt";
        if (contentType.contains("application/json")) return ".json";
        if (contentType.contains("application/pdf")) return ".pdf";
        if (contentType.contains("image/jpeg")) return ".jpg";
        if (contentType.contains("image/png")) return ".png";
        if (contentType.contains("image/gif")) return ".gif";
        if (contentType.contains("text/css")) return ".css";
        if (contentType.contains("application/javascript")) return ".js";
        return ".dat";
    }

}
