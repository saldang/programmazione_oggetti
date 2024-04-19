/**
 * Interface for simple shapes drawn on
 * the screen using keyboard characters.
 */
public interface ShapeInterface {
    /**
Sets the offset for the shape.
     */
    public void setScostamento(int newOffset);
    /**
Returns the offset for the shape.
     */
    public int getScostamento();
    /**
Draws the shape at lineNumber lines down
from the current line.
     */
    public void disegnaDa(int lineNumber);
    /**
Draws the shape at the current line.
     */
    public void disegnaQui();
}
