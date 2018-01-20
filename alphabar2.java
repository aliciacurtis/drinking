public class alphabar2
{
    public static void main (String [] args)
    {
        int[] visited = {0, 8};
        
        String[][] bars = {{"Aeronaut", "Alden & Harlow", "A4cade", "Audubon", "Anchovies", "Atwoods"},
        {"Bantam", "Bleacher Bar", "Backbar", "Brewers Fork", "Brick and Mortar", "Branch Line", "Biddy Earlys", "Bukowski",
        "Brendan Behan", "The Baldwin Bar",	"Belly Wine Bar", "The Brahmin"},
        {"Casa B", "Cantab", "Croke Park", "Coppersmith", "Cafe ArtScience", "Corner", "Cityside", "Cuchi Cuchi"},
        {"Deep Ellum", "Drink", "Delux Cafe", "dbar", "Drinking Fountain", "Druid", "Dillons", "Daedalus"},
        {"Eastern Standard", "Erbaluce", "Eugene O'Neils", "Erie Pub"},
        {"Five Horses", "The Fours", "The Field", "The Frogmore"},
        {"Green Street", "The Glenville Stops", "The Gallows", "Golden Temple", "Gaslight"},
        {"Hawthorne", "Haley Henry", "Hojoko", "Hops N Scotch", "The Haven", "Harborside", "Highland Kitchen"},
        {"The Independent"},
        {"JM Curley", "JJ Foleys", "Jeanie Johnstons"},
        {"The Kirkland Tap", "The Kinsale Pub"},
        {"Lord Hobo", "Loyal 9", "Landmark Public House", "Lucy's", "The Landing"},
        {"Meadhall", "McGreevey's", "Mystic", "Magoun's Saloon"},
        {"Nightshift", "No. 9 Park", "Noir"},
        {"Oak Long Bar", "Ocean Prime", "Orleans", "Om"},
        {"Parlor Sports", "Publick House", "Punk and Poet", "Plough and Stars", "People's Republik"},
        {"Q Restaurant", "The Q"},
        {"Rooftop@Revere", "ReelHouse", "Roza Lyons", "Ryles", "Rag's Tavern"},
        {"Spoke Wine Bar", "Saloon", "State Park", "Sullivan's Tap", "Silvertone", "Stoddard's",
        "Silhouette Lounge", "Sunset Grill", "Shojo", "The Sevens"},
        {"Trina's Starlight",	"Townsman", "The Tam", "Tavern Road", "Taberna de Haro", "Thirsty Scholar", "Tia's"},
        {"Uni"},
        {"Vejigantes", "Venezia", "Vintage Restaurant", "La Voile", "Vee Vees", "Vanderbilt", "Victory Pub"},
        {"Whitey's", "Wally's Cafe", "Ward 8", "Wink & Nod", "Whiskey Priest"},
        {"El Xeilo", "Deuxave", "Delux Cafe"},
        {"Yvonne's", "Yard House"},
        {"Zuzu", "Zeke's Pub"}};
        
        int letter = chooser();
        
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == letter) {
                letter = chooser();
            }
        }
        System.out.println("The letter is " + (char)(letter + 65) + ".");
        int whichbar = (int)(Math.random() * bars[letter].length);
        System.out.println("We're going to " + bars[letter][whichbar] + "!");
    }
    
    public static int chooser()
    {
        return (int)(Math.random() * 26);
    }
    
 
}