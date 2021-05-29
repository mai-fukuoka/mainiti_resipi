package models;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name="myresipis")
@NamedQueries({
    @NamedQuery(
    name="getAllMyresipsis",
            query="SELECT m FROM Myresipi AS m ORDER BY m.id DESC"
            ),
    @NamedQuery(
            name="getMyreipisCount",
            query="SELECT COUNT(m) FROM Myresipi AS m"
            ),
})

public class Myresipi {

}
