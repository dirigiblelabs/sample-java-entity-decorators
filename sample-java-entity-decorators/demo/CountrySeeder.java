package demo;

import org.eclipse.dirigible.engine.java.annotations.Documentation;
import org.eclipse.dirigible.engine.java.annotations.Inject;
import org.eclipse.dirigible.engine.java.annotations.http.Controller;
import org.eclipse.dirigible.engine.java.annotations.http.Post;

/**
 * Stand-alone @Controller that seeds a small fixture set of {@link Country} rows. Kept separate
 * from {@code CountryController} so deleting one controller does not affect the other. Uses the
 * same {@link CountryRepository} via {@code @Inject}.
 */
@Controller
@Documentation("Seeds the sample country fixture")
public class CountrySeeder {

    @Inject
    private CountryRepository countries;

    @Post
    @Documentation("Idempotently seeds three countries; returns either 'seeded' or 'already seeded'")
    public String seed() {
        if (countries.count() > 0) {
            return "already seeded";
        }
        countries.save(country("AF", "AFG", "004", "Afghanistan"));
        countries.save(country("AL", "ALB", "008", "Albania"));
        countries.save(country("DZ", "DZA", "012", "Algeria"));
        return "seeded";
    }

    private static Country country(String code2, String code3, String numericCode, String name) {
        Country c = new Country();
        c.code2 = code2;
        c.code3 = code3;
        c.numericCode = numericCode;
        c.name = name;
        return c;
    }
}
