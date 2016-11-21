import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class ComboBoxDemonstration extends JFrame implements ItemListener
{

   public ComboBoxDemonstration()
   {
	   
      super("City Populations");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(new FlowLayout());
      JComboBox<String> cityChoice = new JComboBox<String>();
      cityChoice.addItem("Oklahoma City");
      cityChoice.addItem("Tulsa");
      cityChoice.addItem("Broken Arrow");
      cityChoice.addItem("Norman");
      cityChoice.addItem("Lawton");
      cityChoice.addItem("Edmond");
      cityChoice.addItem("Moore");
      add(cityChoice);
     
      
      int positionOfSelection = cityChoice.getSelectedIndex();
      int[] population = {599476, 391906, 112000, 110925, 96867, 81405, 55081};
      
      //population [positionOfSelection]

  }
  public static void main(String[] arguments)
  {
      final int FRAME_WIDTH = 150;
      final int FRAME_HEIGHT = 150;
      ComboBoxDemonstration frame = new ComboBoxDemonstration();
      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setVisible(true);
  }
  public void itemStateChanged(ItemEvent check)
  {
	  if (check.getStateChange() == ItemEvent.SELECTED);
		 System.out.println("The city is: "+ check.getItem());

  }
}
