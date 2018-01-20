public class alphabar
{
    public static void main (String [] args)
    {
        char[] visited = new char[] {'A', 'I'};
        
        String[] B = new String[] {"Bantam", "Bleacher Bar", "Backbar", "Brewers Fork", "Brick and Mortar", "Branch Line",
        "Biddy Earlys", "Bukowski",	"Brendan Behan", "The Baldwin Bar",	"Belly Wine Bar", "The Brahmin"};
        String[] C = new String[] {"Casa B", "Cantab", "Croke Park", "Coppersmith", "Cafe ArtScience", "Corner", "Cityside", "Cuchi Cuchi"};
        String[] D = new String[] {"Deep Ellum", "Drink", "Delux Cafe", "dbar", "Drinking Fountain", "Druid", "Dillons", "Daedalus"};
        String[] E = new String[] {"Eastern Standard", "Erbaluce", "Eugene O'Neils", "Erie Pub"};
        String[] F = new String[] {"Five Horses", "The Fours", "The Field", "The Frogmore"};
        String[] G = new String[] {"Green Street", "The Glenville Stops", "The Gallows", "Golden Temple", "Gaslight"};
        String[] H = new String[] {"Hawthorne", "Haley Henry", "Hojoko", "Hops N Scotch", "The Haven", "Harborside", "Highland Kitchen"};
        String[] J = new String[] {"JM Curley", "JJ Foleys", "Jeanie Johnstons"};
        String[] K = new String[] {"The Kirkland Tap", "The Kinsale Pub"};
        String[] L = new String[] {"Lord Hobo", "Loyal 9", "Landmark Public House", "Lucy's", "The Landing"};
        String[] M = new String[] {"Meadhall", "McGreevey's", "Mystic", "Magoun's Saloon"};
        String[] N = new String[] {"Nightshift", "No. 9 Park", "Noir"};
        String[] O = new String[] {"Oak Long Bar", "Ocean Prime", "Orleans", "Om"};
        String[] P = new String[] {"Parlor Sports", "Publick House", "Punk and Poet", "Plough and Stars", "People's Republik"};
        String[] Q = new String[] {"Q Restaurant", "The Q"};
        String[] R = new String[] {"Rooftop@Revere", "ReelHouse", "Roza Lyons", "Ryles", "Rag's Tavern"};
        String[] S = new String[] {"Spoke Wine Bar", "Saloon", "State Park", "Sullivan's Tap", "Silvertone", "Stoddard's",
        "Silhouette Lounge", "Sunset Grill", "Shojo", "The Sevens"};
        String[] T = new String[] {"Trina's Starlight",	"Townsman", "The Tam", "Tavern Road", "Taberna de Haro",
        "Thirsty Scholar", "Tia's"};
        String[] U = new String[] {"Uni"};
        String[] V = new String[] {"Vejigantes", "Venezia", "Vintage Restaurant", "La Voile", "Vee Vees", "Vanderbilt", "Victory Pub"};
        String[] W = new String[] {"Whitey's", "Wally's Cafe", "Ward 8", "Wink & Nod", "Whiskey Priest"};
        String[] X = new String[] {"El Xeilo", "Deuxave", "Delux Cafe"};
        String[] Y = new String[] {"Yvonne's", "Yard House"};
        String[] Z = new String[] {"Zuzu", "Zeke's Pub"};
        
        char letter = chooser();
        
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == letter) {
                letter = chooser();
            }
        }
        /* Okay, so now I have my arrays of bar choices, and I generate my letter. I then want to use that letter to access
        the appropriate array, generate a new number based on that array's length, and pick a bar. But the char "B" is different
        from an array of strings called B. Can I get them to talk to each other? */
        
        // Here's an example, pretending the letter chosen was V. Not super clean, I know, but just making my point:
        
        double i = Math.random() * V.length;
        System.out.println("We're going to " + V[(int)i] + "!");
    }
    
    public static char chooser()
    {
        return (char)((Math.random()) * 26 + 65);
    }
    
 
}