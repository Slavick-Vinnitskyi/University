json.extract! article, :id, :branches_id, :author_id, :title, :text, :created_at, :updated_at
json.url article_url(article, format: :json)
