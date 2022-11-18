using Microsoft.EntityFrameworkCore;
using Model;

namespace agenciaviagens3.Database
{
    public class Viagem : DbContext
    {
        public ViagemDbContext(DbContextOptions<Viagem> options) : base(options) {

        }

        public DbSet<Viagem> viagens { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder) {
            var viagem = modelBuilder.Entity<Destino>();
            viagem.ToTable("viagem");
            viagem.HasKey(x => x.Idviagem);
            viagem.Property(x => x.Idviagem).HasColumnName("IDVIAGEM").ValueGeneratedOnAdd();
            viagem.Property(x => x.IDCj).HasColumnName("IDCJ").IsRequired();
            viagem.Property(x => x.PARTIDA).HasColumnName("PARTIDA").IsRequired();
            viagem.Property(x => x.Destino).HasColumnName("DESTINO").IsRequired();
            viagem.Property(x => x.DATA).HasColumnName("DATA").IsRequired();
            viagem.Property(x => x.VALOR).HasColumnName("VALOR").IsRequired();
        }
    }
}