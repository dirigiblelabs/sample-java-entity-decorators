package demo;

import java.util.List;

import org.eclipse.dirigible.sdk.platform.Documentation;
import org.eclipse.dirigible.sdk.component.Inject;
import org.eclipse.dirigible.sdk.http.Body;
import org.eclipse.dirigible.sdk.http.Controller;
import org.eclipse.dirigible.sdk.http.Delete;
import org.eclipse.dirigible.sdk.http.Get;
import org.eclipse.dirigible.sdk.http.PathParam;
import org.eclipse.dirigible.sdk.http.Post;
import org.eclipse.dirigible.sdk.security.Roles;

/**
 * REST surface for {@link Country}. Demonstrates the recommended client-code pattern: the
 * controller declares a {@code @Inject} {@link CountryRepository} field and never touches
 * {@code JavaEntityStore} or {@code BeanProvider} directly. The engine satisfies the field at
 * controller-load time via the data-store-java repository registry.
 */
@Controller
@Documentation("CRUD over the Country entity")
@Roles({"DEVELOPER"})
public class CountryController {

    @Inject
    private CountryRepository countries;

    @Get("/")
    @Documentation("Lists every Country")
    public List<Country> list() {
        return countries.findAll();
    }

    @Get("/{id}")
    @Documentation("Fetches a single country by id")
    public Country byId(@PathParam("id") Long id) {
        return countries.findById(id);
    }

    @Post
    @Documentation("Creates a new country from a JSON body")
    public Country create(@Body Country country) {
        return countries.save(country);
    }

    @Delete("/{id}")
    @Documentation("Deletes the country with the given id")
    public void remove(@PathParam("id") Long id) {
        countries.deleteById(id);
    }
}
