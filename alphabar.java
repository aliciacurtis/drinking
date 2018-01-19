public class alphabar
{
    public static void main (String [] args)
    {
        char[] visited = new char[] {'A', 'I'};
        char letter = chooser();
        
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == letter) {
                letter = chooser();
            }
        }
        System.out.println("Which letter shall we choose a bar from this time? The letter " + letter + "!");
    }
    
    public static char chooser()
    {
        return (char)((Math.random()) * 26 + 65);
    }
}