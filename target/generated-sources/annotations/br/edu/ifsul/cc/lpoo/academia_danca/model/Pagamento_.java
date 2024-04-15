package br.edu.ifsul.cc.lpoo.academia_danca.model;

import java.util.Calendar;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-14T21:39:22", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Pagamento.class)
public class Pagamento_ { 

    public static volatile SingularAttribute<Pagamento, Double> valor;
    public static volatile SingularAttribute<Pagamento, Calendar> dataPag;
    public static volatile SingularAttribute<Pagamento, Integer> id;
    public static volatile SingularAttribute<Pagamento, Calendar> dataVenc;
    public static volatile SingularAttribute<Pagamento, Double> valorPagamento;

}