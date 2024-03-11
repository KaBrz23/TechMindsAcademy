# TechMindsAcademy

API do projeto TechMinds Academy - Plataforma de venda de cursos

## Documentação

### Endpoints

- [Cadastrar_Usuario](#cadastrar-usuario)
- [Realizar_Login](#realizar-login)
- [Listar_Categorias](#listar-categorias)
- [Listar_Cursos](#listar-cursos)
- [Comprar_Cursos](#comprar-cursos)

---

### Cadastrar Usuario

`POST` /usuario

Cadastrar um novo usuário ao acessar a plataforma.

#### Corpo da Requisição

| campo | tipo | obrigatório | descrição
|:---:|:---:|:---:|:---:|
| `nome_completo`|string |✅| Nome completo do usuário.
| `email`|string |✅| Email para  login e contato.
| `senha`|string |✅| Senha para acessar a plataforma.

```js
{
    "nome": "Kaue Fernandes Braz",
    "email": "rm97768@fiap.com.br",
    "senha": "auladejava"
}
```

#### Exemplo de resposta
```js
{
    "id_usuario": 1,
    "nome-completo": "Kaue Fernandes Braz",
    "email": "rm97768@fiap.com.br",
    "senha": "auladejava"
}
```

#### Código de Status

| código | descrição
|---     | ---
| `201`  | Usuário cadastrado com sucesso
| `400`  | Validação falhou. Verifique as regras para o corpo da requisição

---

### Realizar Login

`POST` /usuario/login

Autentica o usuário na plataforma de cursos.

#### Corpo da Requisição

| campo | tipo | obrigatório | descrição
|:---:|:---:|:---:|:---:|
| `email`|string |✅| Email para  login e contato.
| `senha`|string |✅| Senha para acessar a plataforma.

```js
{
    "email": "rm97768@fiap.com.br",
    "senha": "auladejava"
}
```

#### Exemplo de resposta
```js
{
    "id_login": 1,
    "email": "rm97768@fiap.com.br",
    "senha": "auladejava"
}
```

#### Código de Status

| código | descrição
|---     | ---
| `200`  | Autenticação bem-sucedida.
| `401`  | Você passou credenciais inválidas.

---

### Listar Categorias

`GET` /categoria

Retorna um array com todas as categorias.

#### Exemplo de resposta

```js
[
    {
        "id_categoria": 1,
        "nome": "Desenvolvimento",
        "icone": "java"
    },
    {
        "id_categoria": 2,
        "nome": "Cloud",
        "icone": "cloud"
    },
    {
        "id_categoria": 3,
        "nome": "Dados",
        "icone": "database"
    }
```

#### Código de Status

| código | descrição
|---     | ---
| `200`  | Categorias retornadas com sucesso
| `401`  | Usuário não autenticado. Realize autenticação em /usuario/login

---

### Listar Cursos

`GET` /categoria/{id}/curso

Lista todos os cursos de uma categoria específica

#### Exemplo de resposta

```js
[
    {
        "id_categoria": 1,
        "id_curso": 1,
        "curso": "Documentação de API",
        "descricao": "Curso sobre como documentar API's Restful",
        "preco": 14.99,
        "duracao": "6 horas",
        "instrutor": "Gabriel Fernandes"
    },
    {
        "id_categoria": 1,
        "id_curso": 2,
        "nome": "Java Avançado",
        "descricao": "Aprofunde seus conhecimentos em desenvolvimento web",
        "preco": 199.99,
        "duracao": "120 horas",
        "instrutor": "Kauê Braz"
    },
    // ... outros
```

#### Código de Status

| código | descrição
|---     | ---
| `200`  | Cursos retornados com sucesso
| `401`  | Usuário não autenticado. Realize autenticação em /usuario/login
| `404`  | Não existe curso com o `id` informado. Consulte a lista em /curso

---

### Comprar Cursos

`POST` /usuario/{id_usuario}/comprar

Permite ao usuário comprar cursos na plataforma.

#### Corpo da Requisição

| campo | tipo | obrigatório | descrição
|:---:|:---:|:---:|:---:|
| `id_usuario`|int |✅| ID do usuário que está realizando a compra.
| `preco`|double |✅| preço do curso.
```js
{
    "id_usuario": 1,
    "preco": 199.99
}
```

#### Exemplo de resposta
```js
{
    "id_compra": 1,
    "id_usuario": 1,
    "preco": 199.99
}
```

| código | descrição
|---     | ---
| `201`  | Compra realizada com sucesso
| `400`  | Validação falhou. Verifique as regras para o corpo da requisição
| `401`  | Usuário não autenticado. Realize autenticação em /usuario/login
| `404`  | Não existe uma ou mais dos ids fornecidos. Consulte em /usuario