* FragmentLifecycle
アクティビティとフラグメントのライフサイクル確認用プロジェクト
各ライフサイクルメソッドが呼び出された時にLog表示をする
** 構成
- MainActivity
起動時のアクティビティ。画面サイズによって二つのレイアウトを持つ。
通常画面の場合はレイアウトにMainFragmentのみを持ち、大画面の場合はMainFragmentに加えてSubFragment用のコンテナを持つ。

- SubActivity
通常画面に置けるSubFragment表示用アクティビティ。

- MainFragment
起動時にMainFActivityに表示されるフラグメント。
ボタンを押下すると通常画面ではSubActivityへのインテントが飛び、大画面ではSubFragmentが生成・コミットされる。
- SubFragment


- 気づいたこと
アクティビティからアプリ内の別アクティビティを起動すると、onSaveInstanceState()が呼ばれる。
しかし、元のアクティビティへもどっても、onCreate()等が引数として持つsavedInstanceState()はnullとなり、
Resume Stateのアクティビティの状態が保持されている。