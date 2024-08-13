package br.edu.ifsul.cc.lpoo.academia_danca.model;

import br.edu.ifsul.cc.lpoo.academia_danca.model.Professores;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-08-08T20:18:59", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Modalidade.class)
public class Modalidade_ { 

    public static volatile SingularAttribute<Modalidade, Integer> id;
    public static volatile SingularAttribute<Modalidade, String> descricao;
    public static volatile SingularAttribute<Modalidade, Professores> professores;

}