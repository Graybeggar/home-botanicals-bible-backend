import org.springframework.web.bind.annotation.CrossOrigin; // Import annotation to allow cross-origin requests
import org.springframework.web.bind.annotation.GetMapping; // Import annotation for GET endpoints
import org.springframework.web.bind.annotation.RestController; // Import annotation for REST controller
import java.util.List; // Import List interface
import java.util.Arrays; // Import Arrays utility
import com.homebotanicalsbible.homebotanicalsbiblebackend.model.Tip; // Import Tip model

@RestController // Marks this class as a REST controller for handling HTTP requests
@CrossOrigin // Enables CORS for all origins (frontend can access API)
public class TipController { // Declares the TipController class

    @GetMapping("/tips") // Maps HTTP GET requests to /tips endpoint
    public List<Tip> getTips() { // Returns a list of Tip objects
        return Arrays.asList( // Creates and returns a fixed list of tips
                new Tip(1L, "Test Your Soil – Use a soil test kit to check pH and nutrient levels before planting."),
                new Tip(2L, "Add Organic Matter – Mix in compost or well-rotted manure to improve soil structure and fertility."),
                new Tip(3L, "Use Mulch – Mulch retains moisture, suppresses weeds, and regulates soil temperature."),
                new Tip(4L, "Rotate Crops – Avoid planting the same vegetables in the same spot each year to prevent nutrient depletion and pests."),
                new Tip(5L, "Water Early or Late – Water in the morning or evening to reduce evaporation."),
                new Tip(6L, "Deep Water, Less Often – Encourage deep root growth by watering thoroughly but infrequently."),
                new Tip(7L, "Check Soil Moisture – Stick your finger into the soil; if it’s dry 2 inches down, it’s time to water."),
                new Tip(8L, "Know Your Plants’ Light Needs – Group sun-loving and shade-loving plants separately."),
                new Tip(9L, "Rotate Potted Plants – For even growth, turn pots every week so all sides get light."),
                new Tip(10L, "Use Companion Planting – Basil with tomatoes or marigolds near veggies can deter pests."),
                new Tip(11L, "Attract Beneficial Insects – Ladybugs, lacewings, and bees help control pests and pollinate plants."),
                new Tip(12L, "Inspect Leaves Regularly – Catch problems early by checking for holes, spots, or pests."),
                new Tip(13L, "Deadhead Flowers – Remove spent blooms to encourage more flowering."),
                new Tip(14L, "Prune Properly – Trim plants to remove dead or overcrowded growth and promote airflow."),
                new Tip(15L, "Sprinkle Epsom salt (magnesium sulfate) around tomatoes, peppers, or roses to promote greener leaves and more blooms. Use sparingly — about 1 tablespoon per foot of plant height every couple of weeks."),
                new Tip(16L, "Stake or Trellis Vines – Support climbing plants to prevent rot and maximize space."),
                new Tip(17L, "Keep Tools Clean – Sanitize tools regularly to avoid spreading disease between plants."),
                new Tip(18L, "Keep a Garden Journal – Track what you planted, watering schedules, and any issues or successes.")
        );
    }

    @GetMapping("/tip-of-the-day") // Maps HTTP GET requests to /tip-of-the-day endpoint
    public Tip getTipOfTheDay() { // Returns a single Tip object for the current day
        List<Tip> tips = getTips(); // Gets the list of tips
        if (tips.isEmpty()) return null; // Returns null if no tips are available
        int dayOfYear = java.time.LocalDate.now().getDayOfYear(); // Gets the current day of the year
        int index = dayOfYear % tips.size(); // Calculates index based on day of year
        return tips.get(index); // Returns the tip for today
    }
}
// End of TipController class

// Notes:
// - @RestController: Used to simplify REST API creation; automatically serializes responses to JSON.
// - @CrossOrigin: Enables CORS so frontend apps from any origin can access these endpoints during development.
// - Hardcoded tips in getTips(): Chosen for simplicity and demonstration; avoids database setup for static content.
// - @GetMapping("/tips"): Provides a clear, RESTful endpoint for retrieving all tips.
// - @GetMapping("/tip-of-the-day"): Offers a daily tip feature, improving user engagement.
// - Tip-of-the-day logic: Uses day-of-year modulo tip count for simple, repeatable daily rotation.
// - Returning null if no tips: Quick fallback for empty data.