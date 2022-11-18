using Microsoft.EntityFrameworkCore;
using Model;

namespace agenciaviagens3.Database
{
    public class Pedido : DbContext
    {
        public PedidoDbContext(DbContextOptions<Pedido> options) : base(options) {

        }

        public DbSet<Pedido> pedidos { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder) {
            var pedido = modelBuilder.Entity<Destino>();
            pedido.ToTable("destino");
            pedido.HasKey(x => x.IdPedido);
            pedido.Property(x => x.IdPedido).HasColumnName("IDPEDIDO").ValueGeneratedOnAdd();
            pedido.Property(x => x.IDCF).HasColumnName("IDCF").IsRequired();
            pedido.Property(x => x.IdViagem).HasColumnName("IDVIAGEM").IsRequired();
            pedido.Property(x => x.NomePassageiro).HasColumnName("NOMEPASSAGEIRO").IsRequired();
            pedido.Property(x => x.CpfPassageiro).HasColumnName("CPFPASSAGEIRO").IsRequired();
            pedido.Property(x => x.RgPassageiro).HasColumnName("RGPASSAGEIRO").IsRequired();
            pedido.Property(x => x.Quantidade).HasColumnName("QUANTIDADE").IsRequired();



        }
    }
}