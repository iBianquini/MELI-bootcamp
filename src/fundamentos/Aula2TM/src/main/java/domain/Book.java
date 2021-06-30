package fundamentos.Aula2TM.src.main.java.domain;

import java.math.BigInteger;

public class Book {

    private String nome;
    private BigInteger isbn;
    private String autor;
    private boolean isAvailable;

    public Book() {
    }

    public Book(String nome, BigInteger isbn, String autor, boolean isAvailable) {
        this.nome = nome;
        this.isbn = isbn;
        this.autor = autor;
        this.isAvailable = isAvailable;
    }

    public void emprestimo () throws Exception {
        if (this.isAvailable)
            this.isAvailable = false;
        else
            throw new Exception("Livro indisponivel");
    }

    public void devolver() throws Exception {
        if (!this.isAvailable)
            this.isAvailable = true;
        else
            throw new Exception("Livro não estava emprestado");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigInteger getIsbn() {
        return isbn;
    }

    public void setIsbn(BigInteger isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "nome='" + nome + '\'' +
                ", isbn=" + isbn +
                ", autor='" + autor + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
