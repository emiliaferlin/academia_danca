package br.edu.ifsul.cc.lpoo.academia_danca.model;

import br.edu.ifsul.cc.lpoo.academia_danca.model.FormaPagamento;
import br.edu.ifsul.cc.lpoo.academia_danca.model.Pagamento;
import java.util.Calendar;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-15T20:34:21", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Contrato.class)
public class Contratao_ { 

    public static volatile SingularAttribute<Contrato, FormaPagamento> formaPag;
    public static volatile SingularAttribute<Contrato, Double> valorDesc;
    public static volatile SingularAttribute<Contrato, Integer> id;
    public static volatile SingularAttribute<Contrato, Calendar> dataInicio;
    public static volatile SingularAttribute<Contrato, Pagamento> pagamento;

}