from django.db import models

class Cliente(models.Model):
    nome = models.CharField(max_length=100)
    cpf = models.CharField(max_length=14)

    def __str__(self):
        return self.nome

    class Meta:
        db_table  =  'clientes'
        verbose_name = "cliente"
        verbose_name_plural = "clientes"

class Fabricante(models.Model):
    nome = models.CharField(max_length=100)
    cnpj = models.CharField(max_length=18)

    def __str__(self):
        return self.nome

    class Meta:
        db_table  =  'fabricantes'
        verbose_name = "fabricante"
        verbose_name_plural = "fabricantes"

class Peca(models.Model):
    descricao = models.CharField(max_length=200)
    valor_unit = models.FloatField(null=False)
    fabricante = models.ForeignKey(Fabricante, on_delete=models.CASCADE)
    compras = models.ManyToManyField(Cliente, through='Compra')

    def __str__(self):
        return self.descricao

    class Meta:
        db_table = 'pecas'
        verbose_name = "peca"
        verbose_name_plural = "pecas"

class Compra(models.Model):
    quantidade = models.IntegerField(null=False)
    data = models.DateField(auto_now=False)
    cliente = models.ForeignKey(Cliente, on_delete=models.DO_NOTHING)
    peca = models.ForeignKey(Peca, on_delete=models.DO_NOTHING)

    def __str__(self):
        return self.data

    class Meta:
        db_table  =  'compras'
        verbose_name = "compra"
        verbose_name_plural = "compras"
