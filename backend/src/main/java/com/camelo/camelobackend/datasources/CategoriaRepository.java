package com.camelo.camelobackend.datasources;

import com.camelo.camelobackend.datasources.h2.data.CategoriaData;
import com.camelo.camelobackend.datasources.h2.mapper.CategoriaModelMapper;
import com.camelo.camelobackend.datasources.h2.model.CategoriaModel;
import com.camelo.camelobackend.domain.Categoria;
import com.camelo.camelobackend.ports.CategoriaPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoriaRepository implements CategoriaPort {

    private final CategoriaData data;
    private final CategoriaModelMapper mapper;

    public CategoriaRepository(CategoriaData data) {
        this.data = data;
        this.mapper = CategoriaModelMapper.INSTANCE;
    }

    @Override
    public List<Categoria> categorias() {
        var categoriasModel = (List<CategoriaModel>) data.findAll();
        return categoriasModel.stream().map(mapper::map).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        var email = "secretariafapeu@gmail.com;senadorizalcilucas@senado.leg.br;sergio.cava@ufpel.edu.br;sergio.folle@embrapa.br;sexec@mctic.gov.br;sfgab@cgu.gov.br;shirley@fsadu.org.br;shirleycruz@fundep.com.br;shirleydias@fipt.org.br;sidartaribeiro@neuro.ufrn.br;sidney.carrara@funcate.org.br;silvio@meira.com;siqueira@fujb.ufrj.br;slessa@coppetec.coppe.ufrj.br;slima@fapex.org.br;smoreiraguilherme@gmail.com;socorro@fadesp.org.br;sodrebr@hotmail.com;sola.valery@gmail.com;sonia@fastef.ufc.br;sousad.luana@gmail.com;STAR_JANA@HOTMAIL.COM;stefanie@fujb.ufrj.br;sthephanie@funetec.com;subgab@rfb.gov.br;suchoa@fapex.org.br;suelane@fastef.ufc.br;suellemfiorini@fundep.com.br;superintendente@fadex.org.br;suportewebgroup@gmail.com;suzannafelix@fapec.org;taciana@fundepes.br;taciana@paqtc.org.br;taisesantos@fapec.org;talmeida@fapex.org.br;tamarasoareseco@gmail.com;tania@fadesp.org.br;tassia.contabilidade@uniselva.org.br;tassia.srr@gmail.com;tassiane@fadesp.org.br;tatiana@encontrodigital.com.br;tatiana@fapeu.org.br;tatianafapeu@gmail.com;tatiane@ipead.face.ufmg.br;tavares@funape.org.br;tcaribe@fapex.org.br;tciconia@coppetec.coppe.ufrj.br;tconceicao@fapex.org.br;teotonioroque@funcer.br;teotonioroque@funcern.br;terezacristina@fcpc.ufc.br;terezafcpc@hotmail.com;teste@encontrodigital.com.br;testecris@encontrodigital.com.br;Thais@fau.org.br;thatianepinto@fiotec.fiocruz.br;theanneribeiro@gmail.com;theise@funcate.org.br;themesmesquita@hotmail.com;thiago.silva@uniselva.org.br;thiago@fadesp.org.br;thiago98cavalcanti@gmail.com;thompsonmarizcg@gmail.com;thyara.silva@funarbe.org.br;ti@funtefpr.org.br;tiago.souto@fapec.org;tiagofirmiano@fiotec.fiocruz.br;tilamici@gmail.com;TOMASSANTANA@MEE.GOV.BR;tpecanha@coppetec.coppe.ufrj.br;tsantos@fujb.ufrj.br;tscardoso@hcpa.edu.br;tsouza@fapex.org.br;tulioaugusto@gmail.com;ubirajara@fujb.ufrj.br;uniselva@uniselva.org.br;valentina@paqtc.org.br;valeriab@fipt.org.br;valeriooscaralbuquerque@gmail.com;vandapinheiro@fundep.com.br;vanderlene.santos@mctic.gov.br;vandrade101@gmail.com;vanessa.ferreira@ufrgs.br;vanessa@fapepe.org.br;vanessadara@hotmail.com;vanessadinizmatos@gmail.com;Vanessaestulano@coppetec.ufrj.br;vanessall@tcu.gov.br;vanessapereira@fundep.com.br;vania@fastef.ufc.br;vaniabittencourt@fiotec.fiocruz.br;vaniapeixoto@fiotec.fiocruz.br;VARRAES@FAPEX.ORG.BR;vdanzer@gmail.com;vfroes@fapex.org.br;victo.brresteves@poli.ufrj;victor.aokir@gmail.com;victor.pinheiro@somosfec.org.br;Victor@fau.org.br;victoriadesouzadsilva@gmail.com;vidalrodolfo82@gmail.com;vilmafaria@fipt.org.br;VINICIUS.ALMEIDA@MCTIC.GOV.BR;vinicius.mattaini@somosfec.org.br;vinicius@fujb.ufrj.br;virgilaniafmoreira@gmail.com;vitor@paqtc.org.br;vitoriaellen.ac@gmail.com;vitorluz@fadesp.org.br;vivian.siqueira@somosfec.org.br;vivianemm@tcu.gov.br;vivianemouta@coppetec.coppe.ufrj.br;vivianenunes@fundep.com.br;vivianereporter@gmail.com;vivilacerda1@hotmail.com;vlermen@hcpa.edu.br;vreis@fapex.org.br;vsjesus@fapex.org.br;wagner@fujb.ufrj.br;wallace@coppetec.coppe.ufrj.br;wanessacrosara@hotmail.com;welbber@gmail.com;welldant@yahoo.com.br;widemar@coppetec.coppe.ufrj.br;wigner.fernandes@funpec.br;williamsantanafotografo@gmail.com;willian@fastef.ufc.br;wilsonneto@fiotec.fiocruz.br;WPAULO@FIOTEC.FIOCRUZ.BR;yabrudi@fujb.ufrj.br;yasmimpires@fiotec.fiocruz.br;yonarasilva@fiotec.fiocruz.br;zeny@fujb.ufrj.br;zolacg@tcu.gov;";
        var ttl = email.length();

        System.out.println(ttl);
    }
}
