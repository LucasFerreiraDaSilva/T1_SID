import json, requests
from .models import *

URL_WEB_SERVICE = 'http://10.42.0.209:8080/InterfaceBanco-0.0.1-SNAPSHOT/rest/servicos/'

def putCliente(dic_cliente):
    r = requests.put(URL_WEB_SERVICE, data=dic_cliente)
    if r.status_code == requests.codes.ok:
        print("PUT to "+ URL_WEB_SERVICE+'' +" success! data = "+ str(dic_cliente))
    else:
        print("PUT to "+ URL_WEB_SERVICE+'' +" error! code = "+ r.status_code)

def putFabricante(dic_fabricante):
    r = requests.put(URL_WEB_SERVICE+'', data=dic_fabricante)
    if r.status_code == requests.codes.ok:
        print("PUT to "+ URL_WEB_SERVICE+'' +" success! data = "+ str(dic_fabricante))
    else:
        print("PUT to "+ URL_WEB_SERVICE+'' +" error! code = "+ r.status_code)

def putPeca(dic_peca):
    r = requests.put(URL_WEB_SERVICE, data=dic_peca)
    if r.status_code == requests.codes.ok:
        print("PUT to "+ URL_WEB_SERVICE+'' +" success! data = "+ str(dic_peca))
    else:
        print("PUT to "+ URL_WEB_SERVICE+'' +" error! code = "+ r.status_code)

def putCliente(dic_compra):
    r = requests.put(URL_WEB_SERVICE, data = dic_compra)
    if r.status_code == requests.codes.ok:
        print("PUT to "+ URL_WEB_SERVICE+'' +" success! data = "+ str(dic_compra))
    else:
        print("PUT to "+ URL_WEB_SERVICE+'' +" error! code = "+ r.status_code)

def listFabricante():
    req = requests.get( URL_WEB_SERVICE+'listarfabricantes').json()

    print(req)

    for obj in req:
        nome = obj.get('nome')
        cnpj = obj.get('cnpj')
        c = Fabricante(nome=nome, cnpj=cnpj)
        c.save()


def listCliente():
    req = requests.get( URL_WEB_SERVICE+'listarclientes').json()

    # tratamento para deixar no formato do json do trabalho
    #del r['meta']
    #req = r.get('objects')
    #######################################################
    print(req)

    for obj in req:
        nome = obj.get('nome')
        cpf = obj.get('cpf')
        c = Cliente(nome=nome, cpf=cpf)
        c.save()

def listPecas():
    req = requests.get( URL_WEB_SERVICE+'listarpecas').json()

    print(req)

    for obj in req:
        descricao = obj.get('descricao')
        valor_unit  = obj.get('valorUnitario')
        id_fabricante = obj.get('idFabricante')
        fab = Fabricante.objects.get(pk=id_fabricante)
        p = Peca(descricao=descricao, valor_unit=valor_unit, fabricante=fab)
        p.save()

def listCompras():
    req = requests.get( URL_WEB_SERVICE+'listarcompras').json()

    print(req)

    for obj in req:
        quantidade = obj.get('quantidade')
        data = obj.get('data')
        #valor = obj.get('valor')
        id_cliente = obj.get('idCliente')
        id_peca = obj.get('idPeca')

        cliente = Cliente.objects.get(pk=id_cliente)
        peca = Peca.objects.get(pk=id_peca)
        c = Compra(quantidade=quantidade, data=data, cliente=cliente, peca=peca)
        c.save()
