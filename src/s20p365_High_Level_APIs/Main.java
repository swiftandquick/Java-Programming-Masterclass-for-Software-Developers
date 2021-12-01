package s20p365_High_Level_APIs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {
            // Create a URI.
            URI uri = new URI("http://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");
            // uri.getScheme():  Gets the scheme, which is "http".
            System.out.println("Scheme = " + uri.getScheme());
            // uri.getSchemeSpecificPart():  Gets the scheme-specific part, which is
            // "//username:password@myserver.com:5000/catalogue/phones?os=android#samsung".
            System.out.println("Scheme-specific part = " + uri.getSchemeSpecificPart());
            // uri.getAuthority():  Gets the authority, which is "username:password@myserver.com:5000".
            System.out.println("Authority = " + uri.getAuthority());
            // uri.getUserInfo():  Gets the user info, which is "username:password".
            System.out.println("User info = " + uri.getUserInfo());
            // uri.getHost():  Gets the host, which is "myserver.com".
            System.out.println("Host = " + uri.getHost());
            // uri.getPort():  Gets the port, which is "5000".
            System.out.println("Port = " + uri.getPort());
            // uri.getPath():  Gets the path, which is "/catalogue/phones".
            System.out.println("Path = " + uri.getPath());
            // uri.getQuery():  Gets the query, which is "os=android".
            System.out.println("Query = " + uri.getQuery());
            // uri.getFragment():  Gets the fragment, which is samsung.
            System.out.println("Fragment = " + uri.getFragment());

            /* Connect two URI together to create a new URI.  */
            URI baseUri = new URI("http://username:password@mynewserver.com:5000");
            URI uri1 = new URI("/catalogue/phones?os=android#samsung");
            URI uri2 = new URI("/catalogue/tvs?manufacturer=samsung");
            URI uri3 = new URI("/stores/locations?zip=12345");

            URI resolvedUri1 = baseUri.resolve(uri1);
            URI resolvedUri2 = baseUri.resolve(uri2);
            URI resolvedUri3 = baseUri.resolve(uri3);

            URL url1 = resolvedUri1.toURL();
            System.out.println("URL 1 = " + url1);
            URL url2 = resolvedUri2.toURL();
            System.out.println("URL 2 = " + url2);
            URL url3 = resolvedUri3.toURL();
            System.out.println("URL 3 = " + url3);

            /* Get the relativized URI, which exclude the baseUri from resolvedUri2.  */
            URI relativizedURI = baseUri.relativize(resolvedUri2);
            System.out.println("Relative URI = " + relativizedURI);

            /* Use an actual website's URL.  */
            URL url4 = new URL("http://example.org");

            /* Convert URL to URI.  */
            URI uri4 = url4.toURI();

            System.out.println("Scheme = " + uri4.getScheme());
            System.out.println("Scheme-specific part = " + uri4.getSchemeSpecificPart());
            System.out.println("Authority = " + uri4.getAuthority());
            System.out.println("User info = " + uri4.getUserInfo());
            System.out.println("Host = " + uri4.getHost());
            System.out.println("Port = " + uri4.getPort());
            System.out.println("Path = " + uri4.getPath());
            System.out.println("Query = " + uri4.getQuery());
            System.out.println("Fragment = " + uri4.getFragment());

            /* openStream():  Gets input stream from url4, which is http://example.org.  */
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(url4.openStream()));

            String line = "";

            /* Read and print out all the lines.  This reads the HTML and CSS codes.  */
            while(line != null) {
                line = inputStream.readLine();
                System.out.println(line);
            }

            inputStream.close();

            /* URLConnection represent a communications link between the application and a URL.  In this case, I open
            a URL connection to url4.  */
            URLConnection urlConnection = url4.openConnection();
            /* Argument is true, indicates that the application intends to write data to the URL connection.  */
            urlConnection.setDoOutput(true);
            /* Opens a communications link to the resource referenced by this URL, if such a connection has not already
            been established.  */
            urlConnection.connect();

            /* openStream():  Gets input stream from urlConnection, which is connected to url4 (http://example.org).  */
            BufferedReader inputStream2 = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            /*
            String line2 = "";

            while(line2 != null) {
                line2 = inputStream2.readLine();
                System.out.println(line2);
            }

            inputStream2.close();
             */

            /* Retrieve the headers in the web page.  */
            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();

            /* Print out each key and value.  */
            for(Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                String key = entry.getKey();
                List<String> value = entry.getValue();
                System.out.println("-----key = " + key);
                for(String string : value) {
                    System.out.println("value = " + string);
                }
            }

            URL url5 = new URL("https://api.flickr.com/services/feeds/photos_public.gne?tags=dogs");

            /* HttpURLConnection:  A URLConnection with support for HTTP-specific features.  */
            HttpURLConnection connection = (HttpURLConnection) url5.openConnection();

            /* Set the method of URL request to GET.  */
            connection.setRequestMethod("GET");

            /* Sets the general request property.  If a property with the key (User-Agent) already exists, overwrite
            its value with the new value (Chrome).  */
            connection.setRequestProperty("User-Agent", "Chrome");

            /* Set the read timeout to 30 seconds.  */
            connection.setReadTimeout(30000);

            /* Retrieve the response code as an int value.  */
            int responseCode = connection.getResponseCode();
            System.out.println("Response code:  " + responseCode);

            if(responseCode != 200) {
                System.out.println("Error reading web page.  ");
                return;
            }

            BufferedReader inputReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line3;

            /* Print out the HTML and CSS code.  */
            while((line3 = inputReader.readLine()) != null) {
                System.out.println(line3);
            }

            inputReader.close();

        }
        /* URISyntaxException:  Thrown when a string could not be parsed as a URI reference.  */
        catch(URISyntaxException e) {
            System.out.println("URI Bad Syntax:  " + e.getMessage());
        }
        /* MalformedURLException:  Thrown to indicate that a malformed URL has occurred.  Either no legal protocol
        could be found in a specification string or the string could not be parsed.  */
        catch(MalformedURLException e) {
            System.out.println("URL Malformed:  " + e.getMessage());
        }
        catch(IOException e) {
            System.out.println("IOException:  " + e.getMessage());
        }
    }

}
