# Atividade_1Bim_2Sem - Gerador e Leitor de QR Code

Aplicativo Android desenvolvido como Atividade prática da matéria de
**Programação para Disp. Móveis II**. O app permite gerar um QR Code a partir de
um texto informado pelo usuário e ler QR Codes utilizando a câmera do
dispositivo.

<div align="center">
<img src=".github\project-image.png" alt="Gerador e Leitor de QR Code"/><br />
</div>

## Funcionalidades

- Geração de QR Code a partir de um texto.
- Leitura de QR Code pela câmera do dispositivo.
- Exibição do resultado após a leitura do código.
- Interface nativa para Android.

## Ferramentas utilizadas

- **[Kotlin](https://kotlinlang.org/)**
- **[Android Studio](https://developer.android.com/studio)**
- **[Android SDK](https://developer.android.com/about/versions)**
- **[AndroidX](https://developer.android.com/jetpack/androidx)**
- **[Material Components](https://github.com/material-components/material-components-android)**
- **[ZXing](https://github.com/zxing/zxing)** - Geração dos QR Codes
- **[Google ML Kit](https://developers.google.com/ml-kit/vision/barcode-scanning/code-scanner)** - Leitura dos QR Codes

O projeto utiliza Gradle Kotlin DSL e foi configurado com `compileSdk 36`,
`targetSdk 36` e `minSdk 24`.

> Veja o arquivo [app/build.gradle.kts](app/build.gradle.kts) para consultar as
> dependências e configurações do módulo do aplicativo.

## Como funciona

### Gerar um QR Code

1. Informe um texto no campo de entrada.
2. Toque em **Gerar QR Code**.
3. O código correspondente será exibido na tela.

### Ler um QR Code

1. Toque em **Escanear QR Code**.
2. Aponte a câmera para um QR Code.
3. O conteúdo identificado será exibido no campo de resultado.

## Rodando o projeto (desenvolvimento)

Para executar o aplicativo, é necessário ter o **Android Studio** instalado,
com o Android SDK configurado. Também é preciso utilizar um dispositivo Android
ou um emulador compatível. Para testar a leitura de QR Codes, o dispositivo ou
emulador deve possuir câmera e, preferencialmente, Google Play Services.

```bash
# Clone este repositório

$ git clone https://github.com/CaduZulian/Atividade_1Bim_2Sem.git

# Acesse a pasta do projeto no terminal/cmd

$ cd Atividade_1Bim_2Sem
```

Em seguida, abra a pasta do projeto no Android Studio, aguarde a sincronização
do Gradle e execute a aplicação pelo botão **Run** ou pela opção
**Run > Run 'app'**. Se necessário, crie ou selecione um dispositivo virtual
no **Device Manager**.

Também é possível executar o módulo pelo terminal no Windows:

```bash
.\gradlew.bat assembleDebug
```

O APK de debug será gerado em
`app/build/outputs/apk/debug/app-debug.apk`.

## Rodando o projeto (produção)

Para gerar uma versão de release pelo Android Studio:

1. Abra o projeto no Android Studio.
2. Acesse **Build > Generate Signed App Bundle / APK**.
3. Escolha **APK** ou **Android App Bundle**.
4. Configure uma chave de assinatura ou selecione uma já existente.
5. Selecione a variante `release` e conclua o processo.

O arquivo gerado ficará disponível na pasta de saída indicada pelo Android
Studio, normalmente em `app/build/outputs/apk/release/`.

## Estrutura principal

- [MainActivity.kt](app/src/main/java/com/example/atividade_1bim_2sem/MainActivity.kt) -
  Controla a geração e a leitura dos QR Codes.
- [activity_main.xml](app/src/main/res/layout/activity_main.xml) -
  Define a interface da tela principal.
- [AndroidManifest.xml](app/src/main/AndroidManifest.xml) -
  Contém as configurações principais da aplicação.
- [libs.versions.toml](gradle/libs.versions.toml) -
  Centraliza as versões e dependências utilizadas no projeto.

## TODO's

- Melhorar o tratamento de erros durante a geração e a leitura dos QR Codes.
- Adicionar opções para salvar ou compartilhar o QR Code gerado.
- Adicionar testes automatizados para as principais funcionalidades.

## Desenvolvedores

<table align="center">
<tr>
<td> 
<div align="center">
<img style="width: 150px; border-radius: 50%;" src="https://github.com/CaduZulian.png" alt="CaduZulian"/><br />
<a href="https://github.com/CaduZulian">Carlos Eduardo Zulian</a> 
</div>  
</td>
</tr>
</table>
