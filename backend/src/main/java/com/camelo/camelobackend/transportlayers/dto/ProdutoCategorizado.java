package com.camelo.camelobackend.transportlayers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ProdutoCategorizado
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-11-15T19:59:02.864308-03:00[America/Sao_Paulo]")
public class ProdutoCategorizado   {
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

  @JsonProperty("categorias")
  @Valid
  private List<Categoria> categorias = null;

  public ProdutoCategorizado id(Integer id) {
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

  public ProdutoCategorizado nome(String nome) {
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

  public ProdutoCategorizado url(String url) {
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

  public ProdutoCategorizado preco(Double preco) {
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

  public ProdutoCategorizado desconto(Integer desconto) {
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

  public ProdutoCategorizado categorias(List<Categoria> categorias) {
    this.categorias = categorias;
    return this;
  }

  public ProdutoCategorizado addCategoriasItem(Categoria categoriasItem) {
    if (this.categorias == null) {
      this.categorias = new ArrayList<>();
    }
    this.categorias.add(categoriasItem);
    return this;
  }

  /**
   * Get categorias
   * @return categorias
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<Categoria> getCategorias() {
    return categorias;
  }

  public void setCategorias(List<Categoria> categorias) {
    this.categorias = categorias;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProdutoCategorizado produtoCategorizado = (ProdutoCategorizado) o;
    return Objects.equals(this.id, produtoCategorizado.id) &&
        Objects.equals(this.nome, produtoCategorizado.nome) &&
        Objects.equals(this.url, produtoCategorizado.url) &&
        Objects.equals(this.preco, produtoCategorizado.preco) &&
        Objects.equals(this.desconto, produtoCategorizado.desconto) &&
        Objects.equals(this.categorias, produtoCategorizado.categorias);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, url, preco, desconto, categorias);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProdutoCategorizado {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    preco: ").append(toIndentedString(preco)).append("\n");
    sb.append("    desconto: ").append(toIndentedString(desconto)).append("\n");
    sb.append("    categorias: ").append(toIndentedString(categorias)).append("\n");
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

