

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class CommentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CommentTest
{
    /**
     * Default constructor for test class CommentTest
     */
    public CommentTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    @Test
    public void authorAndRatingStoredCorrectly() {
        Comment c = new Comment("Alex", "Nice product", 4);
        assertEquals("Alex", c.getAuthor());
        assertEquals(4, c.getRating());
    }
    
    @Test
    public void upvoteIncreasesBalance() {
        Comment c = new Comment("Ben", "Good", 3);
        c.upvote();
        assertEquals(1, c.getVoteCount());
    }
    
    @Test
    public void downvoteDecreasesCount() {
        Comment c = new Comment("Chloe", "Not great", 2);
        c.downvote();
        assertEquals(-1, c.getVoteCount());
    }
}    
