package br.edu.ifsul.cc.lpoo.academia_danca.model;

import br.edu.ifsul.cc.lpoo.academia_danca.model.FolhaPagamento;
import br.edu.ifsul.cc.lpoo.academia_danca.model.Modalidade;
import java.util.Calendar;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-08-01T22:23:48", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Professores.class)
public class Professores_ extends Pessoas_ {

    public static volatile ListAttribute<Professores, FolhaPagamento> folhaPag;
    public static volatile SingularAttribute<Professores, Calendar> dataAdmissao;
    public static volatile ListAttribute<Professores, Modalidade> modalidade;

}