class Main
{
  public static void main(String[] args)
  {
    //Accepts text from user
    String userText = "() {} [] []"; //Change what is in the parentheses to change the input text
    System.out.println("\n\n\nInput Text: " + userText + "\n\n");
    
    //Sets up variables to work with the stack
    Stack groupingStack = new Stack(userText.length());
    boolean textBalanced = false;
    String tempString1 = "A";
    String tempString2 = "A";

    //Runs through user text and uses stack accordingly
    for(int i = 0; i < userText.length(); i++)
    {
      tempString1 = userText.substring(i, i + 1);

      //Pushes opening delimiter onto the stack
      if((tempString1.equals("(")) || (tempString1.equals("[")) || (tempString1.equals("{")))
      {
        groupingStack.push(tempString1);
        System.out.println("Pushed char: " + tempString1);
      }

      //Pops opening delimiter off the stack if the correct closing one is detected
      if((tempString1.equals(")")) || (tempString1.equals("]")) || (tempString1.equals("}")))
      {
        if(!(groupingStack.isStackEmpty()))
        {
          tempString2 = groupingStack.pop();
          System.out.println("Pop Trigger char: " + tempString1 + " Popped char:" + tempString2);
          if((tempString1.equals(")")) && !(tempString2.equals("(")))
          {
            groupingStack.push(tempString2);
            System.out.println("Re-pushed: " + tempString2 + "\nCheck loop will be exited.");
            i = userText.length();
          }
          else if((tempString1.equals("]")) && !(tempString2.equals("[")))
          {
            groupingStack.push(tempString2);
            System.out.println("Re-pushed: " + tempString2 + "\nCheck loop will be exited.");
            i = userText.length();
          }
          else if((tempString1.equals("}")) && !(tempString2.equals("{")))
          {
            groupingStack.push(tempString2);
            System.out.println("Re-pushed: " + tempString2 + "\nCheck loop will be exited.");
            i = userText.length();
          }
        }
        else
        {
          groupingStack.push("A");
          System.out.println("Check loop will be exited.");
          i = userText.length();
        }
      }
      tempString2 = "A";
    }

    //Determines if the text is balanced
    if(groupingStack.isStackEmpty())
    {
      textBalanced = true;
    }

    //Displays whether text is balanced or not
    if(textBalanced)
    {
      System.out.println("\nText is fine.");
    }
    else
    {
      System.out.println("\nText is not balanced properly!");
    }
  }
}





//Creates the Stack class
class Stack
{
  //Creates the private data for the Stack class
  private int maxSize;
  private String[] stackArray;
  private int top;

  //Instantiates a Stack class object
  public Stack(int s)
  {
    maxSize = s;
    stackArray = new String[s];
    top = -1;
  }

  //Accesses the maxSize variable for the Stack object
  public int getMaxSize()
  {
    return maxSize;
  }

  //Accesses the stack from the Stack object
  public String[] getStackArray()
  {
    return stackArray;
  }

  //Accesses the top variable for the Stack object
  public int getTop()
  {
    return top;
  }

  //Pushes a String onto the stack
  public void push(String j)
  {
    stackArray[++top] = j;
  }

  //Pops a String off the stack and returns the result
  public String pop()
  {
    return stackArray[top--];
  }

  //Determines whether the stack of a Stack object is empty and returns such information
  public boolean isStackEmpty()
  {
    return (top <= -1);
  }

  //Determines whether the stack of a Stack object is full and returns such information
  public boolean isStackFull()
  {
    return (top >= maxSize - 1);
  }
}

