package com.camelo.camelobackend.transportlayers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Cartao
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-11-15T19:59:02.864308-03:00[America/Sao_Paulo]")
public class Cartao   {
  @JsonProperty("numero")
  private String numero;

  @JsonProperty("nome")
  private String nome;

  @JsonProperty("vencimento")
  private String vencimento;

  @JsonProperty("cvv")
  private Integer cvv;

  public Cartao numero(String numero) {
    this.numero = numero;
    return this;
  }

  /**
   * Get numero
   * @return numero
  */
  @ApiModelProperty(value = "")


  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public Cartao nome(String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Get nome
   * @return nome
  */
  @ApiModelProperty(value = "")


  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Cartao vencimento(String vencimento) {
    this.vencimento = vencimento;
    return this;
  }

  /**
   * Get vencimento
   * @return vencimento
  */
  @ApiModelProperty(value = "")


  public String getVencimento() {
    return vencimento;
  }

  public void setVencimento(String vencimento) {
    this.vencimento = vencimento;
  }

  public Cartao cvv(Integer cvv) {
    this.cvv = cvv;
    return this;
  }

  /**
   * Get cvv
   * @return cvv
  */
  @ApiModelProperty(value = "")


  public Integer getCvv() {
    return cvv;
  }

  public void setCvv(Integer cvv) {
    this.cvv = cvv;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cartao cartao = (Cartao) o;
    return Objects.equals(this.numero, cartao.numero) &&
        Objects.equals(this.nome, cartao.nome) &&
        Objects.equals(this.vencimento, cartao.vencimento) &&
        Objects.equals(this.cvv, cartao.cvv);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numero, nome, vencimento, cvv);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Cartao {\n");
    
    sb.append("    numero: ").append(toIndentedString(numero)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    vencimento: ").append(toIndentedString(vencimento)).append("\n");
    sb.append("    cvv: ").append(toIndentedString(cvv)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

