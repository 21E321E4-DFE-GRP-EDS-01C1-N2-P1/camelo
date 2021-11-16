package com.camelo.camelobackend.transportlayers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Produto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-11-15T19:59:02.864308-03:00[America/Sao_Paulo]")
public class Produto   {
  @JsonProperty("id")
  private Integer id;

  @JsonProperty("nome")
  private String nome;

  @JsonProperty("url")
  private String url;

  @JsonProperty("preco")
  private Double preco;

  @JsonProperty("desconto")
  private Integer desconto;

  public Produto id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(value = "")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Produto nome(String nome) {
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

  public Produto url(String url) {
    this.url = url;
    return this;
  }

  /**
   * Get url
   * @return url
  */
  @ApiModelProperty(value = "")


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Produto preco(Double preco) {
    this.preco = preco;
    return this;
  }

  /**
   * Get preco
   * @return preco
  */
  @ApiModelProperty(value = "")


  public Double getPreco() {
    return preco;
  }

  public void setPreco(Double preco) {
    this.preco = preco;
  }

  public Produto desconto(Integer desconto) {
    this.desconto = desconto;
    return this;
  }

  /**
   * Get desconto
   * @return desconto
  */
  @ApiModelProperty(value = "")


  public Integer getDesconto() {
    return desconto;
  }

  public void setDesconto(Integer desconto) {
    this.desconto = desconto;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Produto produto = (Produto) o;
    return Objects.equals(this.id, produto.id) &&
        Objects.equals(this.nome, produto.nome) &&
        Objects.equals(this.url, produto.url) &&
        Objects.equals(this.preco, produto.preco) &&
        Objects.equals(this.desconto, produto.desconto);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, url, preco, desconto);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Produto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    preco: ").append(toIndentedString(preco)).append("\n");
    sb.append("    desconto: ").append(toIndentedString(desconto)).append("\n");
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

