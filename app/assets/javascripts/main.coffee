$ ->
  $text = $("#text")
  $img = $("#qr")

  # Callback: update image
  updateImg = (enc) ->
    $img.attr("src", "data:image/png;base64," + enc)

  # Update on change
  $text.change ->
    text = $text.val()
    $.ajax "/api/qr",
      data:
        text: text
      success: (enc) ->
        updateImg(enc)

  # Trigger a change
  $text.change()
