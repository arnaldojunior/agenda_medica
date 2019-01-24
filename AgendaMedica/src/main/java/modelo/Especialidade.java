
package modelo;

/**
 *
 * @author claudio.barbosa
 */
public enum Especialidade {

    ACUPUNTURA("Acupunturista"),
    ALERGIA("Alergista"),
    IMUNOLOGIA(""),
    ANESTESIOLOGIA(""),
    ANGIOLOGIA(""),
    CANCEROLOGIA("Oncologista"),
    CARDIOLOGIA("Cardiologista"),
    CIRURGIA_CARDIOVASCULAR("Cirurgião Cardiovascular"),
    CIRURGIA_DA_MAO("Cirurgião de Mão"),
    CIRURGIA_DE_CABECA_E_PESCOCO("Cirurgião de cabeça e pescoço"),
    CIRURGIA_DO_APARELHO_DIGESTIVO("Cirurgia do Aparelho Digestivo"),
    CIRURGIAO_GERAL("Cirurgião Geral"),
    CIRURGIA_PEDIATRICA("Cirurgião Pediátrico"),
    GASTROENTEROLOGIA("Gastroenterologista");
    
    private Long id;
    private final String nome;

    Especialidade(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    
    

}
