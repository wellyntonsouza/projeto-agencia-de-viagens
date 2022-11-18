using Microsoft.EntityFrameworkCore;
using Model;

namespace agenciaviagens3.Database
{
    public class ClienteFisicoDbContext : DbContext
    {
        public ClienteFisicoDbContext(DbContextOptions<ClienteFisicoDbContext> options) : base(options) {

        }

        public DbSet<ClienteFisico> ClientesFisicos { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder) {
            var cf = modelBuilder.Entity<ClienteFisico>();
            cf.ToTable("clientefisico");
            cf.HasKey(x => x.Id);
            cf.Property(x => x.Id).HasColumnName("IDCF").ValueGeneratedOnAdd();
            cf.Property(x => x.Nome).HasColumnName("NOME").IsRequired();
            cf.Property(x => x.RG).HasColumnName("RG").IsRequired();
            cf.Property(x => x.CPF).HasColumnName("CPF").IsRequired();
            cf.Property(x => x.Rua).HasColumnName("RUA").IsRequired();
            cf.Property(x => x.Numero).HasColumnName("NUMERO").IsRequired();
            cf.Property(x => x.Complemento).HasColumnName("COMPLEMENTO").IsRequired();
            cf.Property(x => x.Cidade).HasColumnName("CIDADE").IsRequired();
            cf.Property(x => x.Estado).HasColumnName("ESTADO").IsRequired();
            cf.Property(x => x.Cep).HasColumnName("CEP").IsRequired();
            cf.Property(x => x.Telefone).HasColumnName("TELEFONE").IsRequired();
            cf.Property(x => x.Email).HasColumnName("EMAIL").IsRequired();
            cf.Property(x => x.Senha).HasColumnName("SENHA").IsRequired();



        }
    }
}