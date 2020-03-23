import org.assertj.swing.core.matcher.JButtonMatcher;
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.timing.Pause;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class SwingClassTest {

    private JButtonMatcher addOne= JButtonMatcher.withText("Add 1");
    private JButtonMatcher addTwo= JButtonMatcher.withText("Add 2");
    private JButtonMatcher addThree= JButtonMatcher.withText("Add 3");
    private JButtonMatcher clear= JButtonMatcher.withText("Clear");
    
    private SwingClass swingClass;
    
    private FrameFixture frameFixture;
    
    @BeforeClass
    public void setupBeofreClass(){
        FailOnThreadViolationRepaintManager.install();
    }
    
    @BeforeEach
    public void setup(){
        swingClass= GuiActionRunner.execute(SwingClass::new);
        frameFixture=new FrameFixture(swingClass);
        frameFixture.show();
    }
    
    @Test
    public void testTitle(){
        frameFixture.requireTitle("Adder");
    }
    
    @Test
    public void testAddOne(){
        frameFixture.button(addOne).click();
        Pause.pause();
        frameFixture.textBox().requireText("1").background().requireEqualTo(Color.MAGENTA);
    }
    
    @Test
    public void testAddTwo(){
        frameFixture.button(addTwo).click();
        Pause.pause();
        frameFixture.textBox().requireText("2").background().requireEqualTo(Color.YELLOW);
    }
    
    @Test
    public void testAddThree(){
        frameFixture.button(addThree).click();
        Pause.pause();
        frameFixture.textBox().requireText("3").background().requireEqualTo(Color.BLUE);
    }
    
    @Test
    public void testAddOneAndThree(){
        frameFixture.button(addOne).click();
        frameFixture.button(addThree).click();
        Pause.pause();
        frameFixture.textBox().requireText("4").background().requireEqualTo(Color.BLUE);
    }
    
    @Test
    public void testAddTwoAndThree(){
        frameFixture.button(addTwo).click();
        frameFixture.button(addThree).click();
        Pause.pause();
        frameFixture.textBox().requireText("5").background().requireEqualTo(Color.BLUE);
    }
    
    @Test
    public void testAddOneAndTwo(){
        frameFixture.button(addOne).click();
        frameFixture.button(addTwo).click();
        Pause.pause();
        frameFixture.textBox().requireText("3").background().requireEqualTo(Color.BLUE);
    }
    
    @Test
    public void testAddOneAndClearAndAddTwo(){
        frameFixture.button(addOne).click();
        frameFixture.button(clear).click();
        frameFixture.button(addTwo).click();
        Pause.pause();
        frameFixture.textBox().requireText("2").background().requireEqualTo(Color.BLUE);
    }
    
    @Test
    public void testClear(){
        frameFixture.button(clear).click();
        Pause.pause();
        frameFixture.textBox().requireText("0").background().requireEqualTo(Color.RED);;
    }
    
    
    
    @AfterEach
    public void tearDown() {
        frameFixture.cleanUp();
        swingClass = null;
    }

}
