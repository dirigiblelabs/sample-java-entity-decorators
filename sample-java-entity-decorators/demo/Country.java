package demo;

import org.eclipse.dirigible.sdk.db.Column;
import org.eclipse.dirigible.sdk.platform.Documentation;
import org.eclipse.dirigible.sdk.db.Entity;
import org.eclipse.dirigible.sdk.db.GeneratedValue;
import org.eclipse.dirigible.sdk.db.GenerationType;
import org.eclipse.dirigible.sdk.db.Id;
import org.eclipse.dirigible.sdk.db.Table;

@Entity
@Table(name = "SAMPLE_COUNTRY")
@Documentation("Sample Country Entity")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COUNTRY_ID")
    @Documentation("Auto-generated primary key")
    public Long id;

    @Column(name = "COUNTRY_CODE2", length = 2)
    public String code2;

    @Column(name = "COUNTRY_CODE3", length = 3)
    public String code3;

    @Column(name = "COUNTRY_NUMERIC", length = 3)
    public String numericCode;

    @Column(name = "COUNTRY_NAME", length = 128)
    @Documentation("Official short name")
    public String name;

}
