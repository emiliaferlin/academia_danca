package br.edu.ifsul.cc.lpoo.academia_danca.model;

import br.edu.ifsul.cc.lpoo.academia_danca.model.FormaPagamento;
import br.edu.ifsul.cc.lpoo.academia_danca.model.ItensContrato;
import java.util.Calendar;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-08-02T23:24:55", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Contrato.class)
public class Contrato_ { 

    public static volatile SingularAttribute<Contrato, FormaPagamento> formaPag;
    public static volatile ListAttribute<Contrato, ItensContrato> itensContrato;
    public static volatile SingularAttribute<Contrato, Double> valorDesc;
    public static volatile SingularAttribute<Contrato, Integer> id;
    public static volatile SingularAttribute<Contrato, Calendar> dataInicio;

}