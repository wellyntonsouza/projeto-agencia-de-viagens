using Microsoft.EntityFrameworkCore;
using Model;

namespace agenciaviagens3.Database
{
    public class ClienteJuridicoDbContext : DbContext
    {
        public ClienteJuridicoDbContext(DbContextOptions<ClienteJuridicoDbContext> options) : base(options) {

        }

        public DbSet<ClienteJuridico> ClientesJuridicos { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder) {
            var cj = modelBuilder.Entity<ClienteJuridico>();
            cj.ToTable("clientejuridico");
            cj.HasKey(x => x.IdCj);
            cj.Property(x => x.IdCj).HasColumnName("IDCJ").ValueGeneratedOnAdd();
            cj.Property(x => x.CNPJ).HasColumnName("CNPJ").IsRequired();
            cj.Property(x => x.NOME).HasColumnName("NOME").IsRequired();
            cj.Property(x => x.TELEFONE).HasColumnName("TELEFONE").IsRequired();
            cj.Property(x => x.Email).HasColumnName("EMAIL").IsRequired();
            cj.Property(x => x.SENHA).HasColumnName("SENHA").IsRequired();
        }
    }
}